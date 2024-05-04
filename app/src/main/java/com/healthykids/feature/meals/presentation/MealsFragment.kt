package com.healthykids.feature.meals.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.healthykids.databinding.FragmentMealsBinding
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.healthykids.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsFragment : BaseFragment<Any>() {

    override val mTag = "MealsFragment"
    override val mBinding by lazy { FragmentMealsBinding.inflate(layoutInflater) }

    private val args by navArgs<MealsFragmentArgs>()

    override fun onMyViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViews()
    }

    private fun setUpViews() {
        mBinding.apply {
            btnBack.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            pdfView.fromAsset("${args.calories}.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false).enableDoubletap(true).defaultPage(0)
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null).scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .load()
        }
    }

}