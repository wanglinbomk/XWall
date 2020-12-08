package com.boggle.wall.moudle.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.boggle.wall.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QMUIStatusBarHelper.translucent(this)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        val navigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val controller = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(navigationView, controller)
    }
}