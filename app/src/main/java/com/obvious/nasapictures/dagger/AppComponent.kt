package com.obvious.nasapictures.dagger

import android.content.Context
import com.obvious.nasapictures.NasaApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [ApiModule::class,AppSubcomponents::class])
interface AppComponent{

    fun inject(application: NasaApplication)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : AppComponent
    }
    fun  mainComponent() : MainComponent.Factory


}