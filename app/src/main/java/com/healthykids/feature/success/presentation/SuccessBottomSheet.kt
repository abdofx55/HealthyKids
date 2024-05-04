package com.healthykids.feature.success.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.healthykids.R
import com.example.healthykids.databinding.BottomsheetSuccessBinding
import com.healthykids.core.base.BaseBottomSheet
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SuccessBottomSheet : BaseBottomSheet<SuccessEvent>() {

    override val mViewModel by viewModels<SuccessViewModel>()

    override val mTag = "AddBidConfirmationBottomSheet"
    override val mBinding by lazy { BottomsheetSuccessBinding.inflate(layoutInflater) }

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.viewModel = mViewModel
    }

    override fun renderEvent(event: SuccessEvent) {
        when (event) {
            is SuccessEvent.Done -> back()
        }
    }
}