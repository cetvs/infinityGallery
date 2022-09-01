package com.example.myapplication.di

import android.app.Application
import com.example.di.DataModule
import dagger.Component

@Component(modules = [DataModule::class])
interface AppComponent {
    fun inject(surfApp: Application)
}