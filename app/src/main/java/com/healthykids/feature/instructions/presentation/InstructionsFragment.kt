package com.healthykids.feature.instructions.presentation

import android.os.Bundle
import android.view.View
import com.example.healthykids.databinding.FragmentInstructionsBinding
import com.healthykids.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstructionsFragment : BaseFragment<Any>() {

    override val mTag = "InstructionsFragment"
    override val mBinding by lazy { FragmentInstructionsBinding.inflate(layoutInflater) }

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}