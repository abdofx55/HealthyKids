package com.healthykids.feature.success.presentation

import android.os.Bundle
import android.view.View
import com.example.healthykids.databinding.FragmentSuccessBinding
import com.healthykids.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SuccessFragment : BaseFragment<Any>() {

    override val mTag = "SuccessFragment"
    override val mBinding by lazy { FragmentSuccessBinding.inflate(layoutInflater) }

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

}