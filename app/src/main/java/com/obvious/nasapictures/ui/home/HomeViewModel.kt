package com.obvious.nasapictures.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.obvious.nasapictures.data.DataManager
import com.obvious.nasapictures.data.model.api.ResultList
import io.reactivex.android.schedulers.AndroidSchedulers

class HomeViewModel constructor(private val dataManager: DataManager) : ViewModel() {

    private val listLiveData: MutableLiveData<ResultList> = MutableLiveData()

    fun getListOfImages() {
        dataManager.getImages().observeOn(AndroidSchedulers.mainThread()).subscribe { result ->
            listLiveData.postValue(result)
        }
    }

    fun getLiveData(): LiveData<ResultList> {
        return listLiveData
    }

}