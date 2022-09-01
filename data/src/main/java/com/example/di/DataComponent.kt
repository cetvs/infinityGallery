package com.example.di

import android.app.Application
import dagger.Component

@Component(
//    dependencies = [AppComponent::class],
    modules = [DataModule::class]
)
interface DataComponent {
    fun inject(surfApp: Application)
}