package com.hubert.spacexcomposeql.common.utils

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.onStart

fun <T> StateFlow<T>.afterStart(action: suspend FlowCollector<T>.() -> Unit) = this
    .drop(1)
    .onStart {
        emit(value)
        action.invoke(this)
    }

@Suppress("FunctionName")
fun <T> MutableEventFlow() = MutableSharedFlow<T>(extraBufferCapacity = 1)
