package com.healthykids.utils.databinding

import android.content.Context
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.healthykids.utils.Message

class ObservableMessage(
    vararg dependencies: Observable
) : ObservableField<Message>(*dependencies) {

    init {
        set(Message(""))
    }

    fun get(context: Context) = super.get()?.getValue(context)

}