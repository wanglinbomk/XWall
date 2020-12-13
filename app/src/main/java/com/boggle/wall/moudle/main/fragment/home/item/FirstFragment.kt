package com.boggle.wall.moudle.main.fragment.home.item

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.boggle.wall.R
import com.boggle.wall.databinding.FirstFragmentBinding
import com.boggle.wall.moudle.main.fragment.adapter.GlideImageLoader
import com.boggle.wall.utils.ScreenUtils
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.activity_main.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FirstFragmentBinding
    private var data = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.first_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        binding.firstFragmentVM = viewModel
        binding.lifecycleOwner = this
        initTestData()
    }

    private fun initTestData() {
        data.add("https://pixabay.com/get/53e8d54a4f57a514f1dc846096293e7d113adaed554c704f752873d09248c150_640.jpg")
        data.add("https://pixabay.com/get/53e8d4414955a914f1dc846096293e7d113adaed554c704f752873d09248c150_640.jpg")
        binding.banner.setLayoutParams(
            ScreenUtils.getBannerParams(
                binding.banner,
                fragment.context
            )
        )
        binding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
            .setImageLoader(GlideImageLoader())
            .setImages(data)
            .setBannerAnimation(Transformer.ZoomOutSlide)
            .isAutoPlay(true)
            .setDelayTime(2000)
            .setIndicatorGravity(BannerConfig.CENTER)
            .start()

    }

}