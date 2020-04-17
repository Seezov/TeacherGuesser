package com.example.teacherguesser.extensions

import android.content.Context
import kotlin.math.roundToInt

fun Number.toDp(context: Context) =
    (this.toDouble() * context.resources.displayMetrics.density).roundToInt()
