package com.healthykids.utils.databinding

import androidx.databinding.Observable
import androidx.databinding.ObservableField


class ObservableString(
    vararg dependencies: Observable
) : ObservableField<String>(*dependencies) {

    init {
        set("")
    }

    override fun get(): String = super.get() ?: ""

}