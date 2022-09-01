package com.example.myapplication

import android.app.Application
import com.example.di.DaggerDataComponent
import com.example.di.DataComponent
import com.example.domain.di.DaggerDomainComponent
import com.example.domain.di.DomainComponent
import com.example.myapplication.di.AppComponent

lateinit var appComponent: AppComponent
lateinit var dataComponent: DataComponent
lateinit var domainComponent: DomainComponent

//@HiltAndroidApp
class SurfApp: Application() {
    override fun onCreate() {
        super.onCreate()
//        dataComponent = Dagger
        dataComponent = DaggerDataComponent.create()
        domainComponent = DaggerDomainComponent.create()
    }
}