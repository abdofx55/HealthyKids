package com.healthykids.feature.calculate_calories.presentation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.healthykids.databinding.FragmentCaloriesBinding
import com.healthykids.core.base.BaseFragment
import com.healthykids.feature.calculate_calories.domain.Activity
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.Sex
import com.healthykids.feature.calculate_calories.domain.WeightType
import com.healthykids.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CaloriesFragment : BaseFragment<CaloriesEvent>() {

    override val mTag = "CaloriesFragment"
    override val mViewModel by viewModels<CaloriesViewModel>()
    override val mBinding by lazy { FragmentCaloriesBinding.inflate(layoutInflater) }

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.apply {
            viewModel = mViewModel
        }
    }

    override fun renderEvent(event: CaloriesEvent) {
        when (event) {
            is CaloriesEvent.SexListFetched -> renderSexList(event.data)
            is CaloriesEvent.AgeListFetched -> renderAgeList(event.data)
            is CaloriesEvent.ActivityTypeFetched -> renderActivityList(event.data)
            CaloriesEvent.ShowResultForNormalWeight -> navigateToSuccess()
            is CaloriesEvent.ShowResultForOverWeight -> navigateToResult(
                event.weightType, event.calories
            )
        }
    }

    private fun renderSexList(sexList: MutableList<Sex>) {
        with(mBinding.tvSex) {
            val items = sexList.map { it.getName() }.toMutableList()

            val adapter = ArrayAdapter(
                requireContext(), android.R.layout.simple_dropdown_item_1line, items
            )
            setAdapter(adapter)
            setOnItemClickListener { _, _, position, _ ->
                mViewModel.onSexSelected(sexList[position])
            }
        }
    }

    private fun renderAgeList(ageList: MutableList<Age>) {
        with(mBinding.tvAge) {
            val items = ageList.map { it.getName() }.toMutableList()

            val adapter = ArrayAdapter(
                requireContext(), android.R.layout.simple_dropdown_item_1line, items
            )
            setAdapter(adapter)
            setOnItemClickListener { _, _, position, _ ->
                mViewModel.onAgeSelected(ageList[position])
            }
        }
    }

    private fun renderActivityList(activityList: MutableList<Activity>) {
        with(mBinding.tvActivity) {
            val items = activityList.map { it.getName() }.toMutableList()

            val adapter = ArrayAdapter(
                requireContext(), android.R.layout.simple_dropdown_item_1line, items
            )
            setAdapter(adapter)
            setOnItemClickListener { _, _, position, _ ->
                mViewModel.onActivitySelected(activityList[position])
            }
        }
    }

    private fun navigateToSuccess() {
        navigate(CaloriesFragmentDirections.actionCaloriesFragmentToSuccessFragment())
    }

    private fun navigateToResult(weightType: WeightType, calories: Int) {
        navigate(
            CaloriesFragmentDirections.actionCaloriesFragmentToResultBottomSheet(
                weightType, calories
            )
        )
    }

}