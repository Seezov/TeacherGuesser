package com.example.teacherguesser

import android.app.Application
import com.example.teacherguesser.di.components.AppComponent
import com.example.teacherguesser.di.components.DaggerAppComponent

open class TeacherGuesserApp : Application() {

    open val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    @Deprecated("Remove this", replaceWith = ReplaceWith("KidsloxApp.component"))
    fun component(): AppComponent = component

    init {
        application = this
    }

    companion object {

        @Suppress("unused")
        private val TAG = TeacherGuesserApp::class.java.simpleName

        lateinit var application: TeacherGuesserApp
            private set
    }
}
