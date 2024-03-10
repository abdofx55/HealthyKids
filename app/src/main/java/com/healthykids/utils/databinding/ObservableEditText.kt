package com.eahs.utils.databinding

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import com.eahs.R
import com.eahs.utils.Message

class ObservableEditText {
    val userInput = ObservableString()
    val error = ObservableMessage()
    var hint = ObservableInt()
    val isVisible = ObservableBoolean()
    val isEnabled = ObservableBoolean()
    val inputType = ObservableInt()
}

fun checkIfFieldEmpty(vararg editText: ObservableEditText): Boolean {
    var empty = false
    editText.forEach {
        if (it.userInput.get().isTrimEmpty()) {
            it.error.set(Message(R.string.field_required))
            empty = true
        } else it.error.set(Message(R.string.empty))
    }

    return empty
}