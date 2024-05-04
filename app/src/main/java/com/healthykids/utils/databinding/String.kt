package com.healthykids.utils.databinding

fun String?.isTrimNotEmpty() = this?.trim()?.isNotEmpty() == true
fun String?.isTrimEmpty() = this?.trim()?.isEmpty() == true
