package com.example.domain.di

import android.app.Application
import dagger.Component

@Component(
    modules = [DomainModule::class]
)
interface DomainComponent {
    fun inject(surfApp: Application)
}