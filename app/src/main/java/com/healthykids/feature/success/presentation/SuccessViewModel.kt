package com.healthykids.feature.success.presentation

import com.healthykids.core.base.BaseCoroutineDispatchers
import com.healthykids.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SuccessViewModel @Inject constructor(
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<SuccessEvent>(dispatchers) {

    fun done() {
        pushSingle(SuccessEvent.Done)
    }

}