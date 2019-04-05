package com.raywenderlich.android.reactiveexample

import java.util.*

data class Todo(
    val text: String,
    val addedDate: Date,
    val isDone: Boolean
)