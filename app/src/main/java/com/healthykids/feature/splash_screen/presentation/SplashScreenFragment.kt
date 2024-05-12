package com.healthykids.feature.splash_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.healthykids.databinding.FragmentSplashScreenBinding
import com.healthykids.core.base.BaseFragment
import com.healthykids.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment<SplashScreenEvent>() {

    override val mTag = "SplashScreenFragment"
    override val mViewModel by viewModels<SplashScreenViewModel>()
    override val mBinding by lazy { FragmentSplashScreenBinding.inflate(layoutInflater) }

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {}

    override fun renderEvent(event: SplashScreenEvent) {
        when (event) {
            is SplashScreenEvent.NavigateToNextScreen -> navigateToCalculateCaloriesFragment()
        }
    }

    private fun navigateToCalculateCaloriesFragment() {
        navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToCaloriesFragment())
    }

}