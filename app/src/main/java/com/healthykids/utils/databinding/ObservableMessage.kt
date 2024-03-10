package com.eahs.utils.databinding

import android.content.Context
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.eahs.utils.Message

class ObservableMessage(
    vararg dependencies: Observable
) : ObservableField<Message>(*dependencies) {

    init {
        set(Message(""))
    }

    fun get(context: Context) = super.get()?.getValue(context)

}