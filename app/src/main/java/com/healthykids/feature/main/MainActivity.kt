package com.healthykids.feature.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.healthykids.databinding.ActivityMainBinding
import com.healthykids.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainEvent>() {

    override val mTag = "MainActivity"
    override val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override val mViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setupViews()
    }

    private fun setupViews() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

}