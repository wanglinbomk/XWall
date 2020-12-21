package com.boggle.wall.moudle.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavigatorProvider
import androidx.navigation.fragment.NavHostFragment
import com.boggle.wall.R
import com.boggle.wall.databinding.ActivityMainBinding
import com.boggle.wall.moudle.main.fragment.day.DayFragment
import com.boggle.wall.moudle.main.fragment.home.HomeFragment
import com.boggle.wall.moudle.main.fragment.type.TypeFragment
import com.boggle.wall.moudle.weight.FixFragmentNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        QMUIStatusBarHelper.translucent(this)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        //获取页面容器NavHostFragment
        var fragment = getSupportFragmentManager().findFragmentById(R.id.fragment)
        //获取导航控制器
        var navController = NavHostFragment.findNavController(fragment!!)
        //创建自定义的Fragment导航器
        var fragmentNavigator =
            FixFragmentNavigator(this, fragment.getChildFragmentManager(), fragment.getId());
        //获取导航器提供者
        var provider = navController.getNavigatorProvider();
        //把自定义的Fragment导航器添加进去
        provider.addNavigator(fragmentNavigator);
        //手动创建导航图
        var navGraph = initNavGraph(provider, fragmentNavigator);
        //设置导航图
        navController.graph = navGraph
        //底部导航设置点击事件
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                navController.navigate(item.getItemId());
                return true
            }

        })
    }

    private fun initNavGraph(
        provider: NavigatorProvider,
        fragmentNavigator: FixFragmentNavigator
    ): NavGraph {
        var navGraph = NavGraph(NavGraphNavigator(provider));

        //用自定义的导航器来创建目的地
        var destination1 = fragmentNavigator.createDestination();
        destination1.setId(R.id.homeFragment)
        destination1.setClassName(HomeFragment::class.java.getCanonicalName())
        navGraph.addDestination(destination1)

        //省略
        var destination2 = fragmentNavigator.createDestination();
        destination2.setId(R.id.typeFragment)
        destination2.setClassName(TypeFragment::class.java.getCanonicalName())
        navGraph.addDestination(destination2);
        //省略
        var destination3 = fragmentNavigator.createDestination();
        destination3.setId(R.id.dayFragment)
        destination3.setClassName(DayFragment::class.java.getCanonicalName())
        navGraph.addDestination(destination3);

        navGraph.setStartDestination(R.id.homeFragment);
        return navGraph;
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
