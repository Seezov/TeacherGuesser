package com.example.teacherguesser.extensions

import android.content.Context
import com.example.teacherguesser.TeacherGuesserApp
import com.example.teacherguesser.di.components.AppComponent

val Context.component: AppComponent
    get() = (applicationContext as TeacherGuesserApp).component()