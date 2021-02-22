package com.obvious.nasapictures

import android.app.Activity
import android.app.Application
import com.obvious.nasapictures.dagger.AppComponent
import com.obvious.nasapictures.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

open class NasaApplication : Application(){


    val appComponent: AppComponent by lazy {
    initializeComponent()
    }
    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}



