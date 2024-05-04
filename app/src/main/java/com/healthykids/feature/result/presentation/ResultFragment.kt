package com.healthykids.feature.result.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.healthykids.databinding.FragmentResultBinding
import com.healthykids.core.base.BaseFragment
import com.healthykids.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<ResultEvent>() {

    override val mTag = "ResultFragment"
    override val mBinding by lazy { FragmentResultBinding.inflate(layoutInflater) }
    override val mViewModel by viewModels<ResultViewModel>()


    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.apply {
            viewModel = mViewModel
            btnBack.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun renderEvent(event: ResultEvent) {
        when (event) {
            is ResultEvent.NavigateToMeals -> navigateToMeals(event.calories)
            ResultEvent.NavigateToInstructions -> navigateToInstructions()
            ResultEvent.Cancel -> back()
        }
    }

    private fun navigateToMeals(calories: Int) {
        navigate(ResultFragmentDirections.actionResultFragmentToMealsFragment(calories))
    }

    private fun navigateToInstructions() {
        navigate(ResultFragmentDirections.actionResultFragmentToInstructionsFragment())
    }
}