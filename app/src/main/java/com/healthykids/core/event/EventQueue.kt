package com.eahs.core.event

import kotlinx.coroutines.flow.Flow

interface EventQueue<out T> {

    fun getFor(consumerId: String): Flow<T>
}