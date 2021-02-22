package com.obvious.nasapictures.dagger

import com.obvious.nasapictures.ui.home.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainComponent{

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }
    fun inject(activity: MainActivity)
}