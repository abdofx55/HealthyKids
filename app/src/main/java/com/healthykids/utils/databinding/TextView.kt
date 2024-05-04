package com.healthykids.utils.databinding

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:addUnderLine")
fun TextView.addUnderLine(boolean: Boolean) {
    if (boolean)
        this.paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG
}
