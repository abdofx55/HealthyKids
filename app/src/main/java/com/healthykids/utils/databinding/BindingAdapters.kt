package com.eahs.utils.databinding

import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton
import com.healthykids.utils.databinding.ObservableString
import com.healthykids.utils.databinding.isTrimEmpty

@BindingAdapter(
    value = ["observeInputField1",
        "observeInputField2",
        "observeInputField3",
        "observeInputField4",
        "observeInputField5",
        "observeInputField6"
    ], requireAll = false
)
fun setIsEnabled(
    button: MaterialButton,
    inputField1: ObservableString?,
    inputField2: ObservableString?,
    inputField3: ObservableString?,
    inputField4: ObservableString?,
    inputField5: ObservableString?,
    inputField6: ObservableString?
) {
    var enableButton = true

    when {
        inputField1?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }

        inputField2?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }

        inputField3?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }

        inputField4?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }

        inputField5?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }

        inputField6?.get()?.isTrimEmpty() == true -> {
            enableButton = false
        }
    }
    button.isEnabled = enableButton
}