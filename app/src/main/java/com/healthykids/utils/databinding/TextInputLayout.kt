package com.eahs.utils.databinding

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.eahs.utils.Message
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorMessage(
    errorMessage: Message?
) {
    errorMessage?.let {
        val message = errorMessage.getValue(context)
        isErrorEnabled = message.isNotEmpty()
        error = message
    }
}

@BindingAdapter("hint")
fun setHint(view: TextInputLayout, @StringRes hint: Int) {
    hint.let {
        if (hint != 0)
            view.hint = view.context.getString(hint)

    }
}

@BindingAdapter("hint")
fun setHint(view: TextInputEditText, @StringRes hint: Int) {
    hint.let {
        if (hint != 0)
            view.hint = view.context.getString(hint)

    }
}

@BindingAdapter("inputType")
fun setInputType(view: TextInputEditText, inputType: Int) {
    view.inputType = inputType
}