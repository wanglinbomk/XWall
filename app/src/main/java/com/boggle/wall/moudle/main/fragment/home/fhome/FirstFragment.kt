package com.boggle.wall.moudle.main.fragment.home.fhome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.SingleLayoutHelper
import com.boggle.wall.R
import com.boggle.wall.databinding.FirstFragmentBinding
import com.boggle.wall.moudle.main.fragment.adapter.BannerAdapter
import com.boggle.wall.moudle.main.fragment.adapter.BottomTitleAdapter
import com.boggle.wall.moudle.main.fragment.adapter.HeadTitleAdapter
import com.boggle.wall.moudle.main.fragment.adapter.HorizontalViewAdapter
import com.boggle.wall.utils.RequestUtils
import com.chad.library.adapter.base.BaseViewHolder
import java.util.*


class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FirstFragmentBinding

    private var layoutManager: VirtualLayoutManager? = null

    //复用池塘
    private var viewPool: RecycledViewPool? = null
    private var isFirst = true

    //vlayout Adapter
    private var delegateAdapter: DelegateAdapter? = null

    //一个Adapter对应一个类型，这里通过自增加1实现唯一性
    private var itemType = 0

    //不同类型的Adapter
    private var adapters: MutableList<DelegateAdapter.Adapter<BaseViewHolder>>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.first_fragment, container, false)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        binding.firstFragmentVM = viewModel
        binding.lifecycleOwner = this
        if (isFirst) {
            initValyout()
            isFirst = !isFirst
        }
    }

    private fun initValyout() {
        layoutManager = VirtualLayoutManager(requireContext())
        layoutManager?.setRecycleOffset(600)
        layoutManager?.setInitialPrefetchItemCount(10)
        binding.rvFirstAll.layoutManager = layoutManager
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        //针对type=0的item设置了复用池的大小，如果你的页面有多种type，需要为每一种类型的分别调整复用池大小参数。
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        //针对type=0的item设置了复用池的大小，如果你的页面有多种type，需要为每一种类型的分别调整复用池大小参数。
        viewPool = RecycledViewPool()
        binding.rvFirstAll.setRecycledViewPool(viewPool)
        viewPool?.setMaxRecycledViews(0, 20)
        //加载数据，通过创建adapter集合实现布局
        //加载数据，通过创建adapter集合实现布局
        delegateAdapter = DelegateAdapter(layoutManager, false) //必须使用false，实现每一个分组的类型不同
        binding.rvFirstAll.adapter = delegateAdapter
        initData()
    }

    private fun initData() {
        //banner
        viewModel.loadHeadData(requireActivity()).observe(viewLifecycleOwner, Observer {
            if (adapters == null) {
                adapters = ArrayList()
            }
            var bannerStr = mutableListOf<String>()
            for (item in it) {
                bannerStr.add(item.webformatURL)
            }
            viewPool!!.setMaxRecycledViews(itemType++, 1)
            var bannerAdapter = BannerAdapter(
                SingleLayoutHelper(),
                1,
                R.layout.item_home_banner,
                requireContext(),
                1,
                bannerStr
            )
            adapters?.add(bannerAdapter)
            //title
            viewPool!!.setMaxRecycledViews(itemType++, 1)
            var headTitleAdapter = HeadTitleAdapter(
                SingleLayoutHelper(), 1, R.layout.item_type_title, requireContext(), 2
                , RequestUtils.getInstance().headTitles
            )
            adapters?.add(headTitleAdapter)
            //horizontal
            viewModel.loadHorizontal(requireActivity()).observe(viewLifecycleOwner, Observer {
                viewPool!!.setMaxRecycledViews(itemType++, 1)
                var horizontalViewAdapter = HorizontalViewAdapter(
                    SingleLayoutHelper(),
                    1,
                    R.layout.item_recycler,
                    requireContext(),
                    3,
                    it
                )
                adapters?.add(horizontalViewAdapter)
                delegateAdapter!!.setAdapters(adapters!! as List<DelegateAdapter.Adapter<RecyclerView.ViewHolder>>?)
            })
        })
    }
}