package com.obvious.nasapictures.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.obvious.nasapictures.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers

class HomeViewModel constructor(private val dataManager: DataManager): ViewModel(){


    fun getListOfImages(){
        dataManager.getImages().observeOn(AndroidSchedulers.mainThread()).subscribe{result ->
            Log.d("TAG","SUCCESS");
        }
    }


}