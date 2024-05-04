package com.healthykids.feature.main

import com.healthykids.core.base.BaseCoroutineDispatchers
import com.healthykids.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<MainEvent>(dispatchers)