package com.healthykids.feature.instructions.presentation

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.healthykids.databinding.FragmentCaloriesBinding
import com.example.healthykids.databinding.FragmentInstructionsBinding
import com.healthykids.core.base.BaseFragment
import com.healthykids.feature.calculate_calories.domain.Activity
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.Sex
import com.healthykids.feature.calculate_calories.presentation.CaloriesEvent
import com.healthykids.feature.calculate_calories.presentation.CaloriesFragmentDirections
import com.healthykids.feature.calculate_calories.presentation.CaloriesViewModel
import com.healthykids.utils.navigate
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