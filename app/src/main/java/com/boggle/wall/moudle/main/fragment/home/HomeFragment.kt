package com.boggle.wall.moudle.main.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.boggle.wall.R
import com.boggle.wall.databinding.HomeFragmentBinding
import com.boggle.wall.moudle.main.fragment.adapter.MyViewPagerAdapter
import com.boggle.wall.moudle.main.fragment.home.fhome.FirstFragment
import com.boggle.wall.moudle.main.fragment.home.fhot.HotFragment
import com.boggle.wall.moudle.main.fragment.home.flast.LastFragment
import com.qmuiteam.qmui.util.QMUIDisplayHelper

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    private var titles = mutableListOf<String>()
    private var mMyViewPagerAdapter: MyViewPagerAdapter? = null
    private var fragments: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragments.add(FirstFragment())
        fragments.add(HotFragment())
        fragments.add(LastFragment())

        titles.add("最初のページ")
        titles.add("人気がある")
        titles.add("最新の")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this
        binding.clAll.setPadding(0,(QMUIDisplayHelper.getActionBarHeight(context)/2).toInt(),0,0)

        mMyViewPagerAdapter = MyViewPagerAdapter(requireActivity().supportFragmentManager, titles, fragments)
        binding.vpAll.adapter = mMyViewPagerAdapter
        binding.stAll.setViewPager(binding.vpAll)
        binding.stAll.setCurrentTab(0)
        binding.vpAll.setOffscreenPageLimit(fragments.size)
    }
}