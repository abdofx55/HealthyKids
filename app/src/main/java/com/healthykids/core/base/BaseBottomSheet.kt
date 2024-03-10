package com.healthykids.core.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch


abstract class BaseBottomSheet<E> : BottomSheetDialogFragment() {

    abstract val mTag: String
    abstract val mBinding: ViewBinding
    open val mViewModel: BaseViewModel<E>? = null

    protected val cancelable: Boolean = false
    protected val canceledOnTouchOutside: Boolean = false

    protected abstract fun onMyViewCreated(view: View, savedInstanceState: Bundle?)
    protected open fun renderEvent(event: E) {}

    private val layoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        val behavior = BottomSheetBehavior.from(view?.parent as View)
        behavior.peekHeight = view!!.height
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        loadInitialData()
        return mBinding.root.let { root ->
            root.parent?.let { parent -> (parent as ViewGroup).removeView(root) }
            root
        }
    }

    override fun onStart() {
        super.onStart()
        view?.viewTreeObserver?.addOnGlobalLayoutListener(layoutListener)
    }

    override fun onStop() {
        super.onStop()
        view?.viewTreeObserver?.removeOnGlobalLayoutListener(layoutListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onMyViewCreated(view, savedInstanceState)
        observeEvents()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme).apply {
            setCancelable(cancelable)
            setCanceledOnTouchOutside(canceledOnTouchOutside)
        }
    }


    private fun observeEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                mViewModel?.eventQueue?.getFor(mTag)?.collect { event ->
                    renderEvent(event)
                }
            }
        }
    }

    private fun loadInitialData() {
        mViewModel?.loadInitialData()
    }

    fun back() {
        findNavController().navigateUp()
    }

}