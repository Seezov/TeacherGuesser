package com.example.teacherguesser.di.modules

import android.app.Application
import com.example.teacherguesser.TeacherGuesserApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {

    @Provides
    @Singleton
    internal fun provideApplication(): Application = TeacherGuesserApp.application
}