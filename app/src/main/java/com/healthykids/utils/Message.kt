package com.healthykids.utils

import android.content.Context

class Message {
    var text: String = ""
    var formatArgs: String? = null
    var resource: Int = -1

    constructor(text: String) {
        this.text = text
    }

    constructor(resource: Int) {
        this.resource = resource
    }

    constructor(resource: Int, formatArgs: String) {
        this.resource = resource
        this.formatArgs = formatArgs
    }

    fun getValue(context: Context?): String {
        return if (resource == -1) text
        else formatArgs?.let { args ->
            context?.getString(resource, args)
        } ?: run { context?.getString(resource) ?: "" }
    }

    fun getValue(context: Context?, formatArgs: String): String {
        return if (resource == -1) text
        else context?.getString(resource, formatArgs) ?: ""
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (text != other.text) return false
        if (resource != other.resource) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text.hashCode()
        result = 31 * result + resource
        return result
    }


}