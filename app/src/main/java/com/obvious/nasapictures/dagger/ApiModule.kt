package com.obvious.nasapictures.dagger

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obvious.nasapictures.R
import com.obvious.nasapictures.data.AppDatamanager
import com.obvious.nasapictures.data.DataManager
import com.obvious.nasapictures.data.local.ApiManager
import com.obvious.nasapictures.data.local.GsonApiManager
import com.obvious.nasapictures.data.model.api.NasaItem
import com.obvious.nasapictures.data.model.api.ResultList
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideData(context: Context) :ResultList  {
        val json =
            context.resources.openRawResource(R.raw.data).bufferedReader().use { it.readText()
            }
        val listType = object : TypeToken<List<NasaItem?>?>() {}.type
        val gson :List<NasaItem>  = Gson().fromJson(json,listType)
        return ResultList(gson)
    }
    @Provides
    @Singleton
    fun provideDataManager(appDatamanager: AppDatamanager) : DataManager{
       return appDatamanager
    }
    @Provides
    @Singleton
    fun provideApiManager(gsonApiManager: GsonApiManager): ApiManager{
        return gsonApiManager
    }
}