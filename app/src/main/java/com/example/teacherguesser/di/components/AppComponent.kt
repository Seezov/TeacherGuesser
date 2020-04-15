package com.example.teacherguesser.di.components

import com.example.teacherguesser.TeacherGuesserApp
import com.example.teacherguesser.activities.BaseMvvmActivity
import com.example.teacherguesser.di.modules.SystemModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        SystemModule::class
    ]
)
@Singleton
interface AppComponent {

    //region Application

    fun inject(teacherGuesserApp: TeacherGuesserApp)
    //endregion

    //region Activities

    fun inject(activity: BaseMvvmActivity)
    //endregion
}