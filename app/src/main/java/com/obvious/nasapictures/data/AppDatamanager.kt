package com.obvious.nasapictures.data

import com.obvious.nasapictures.data.local.ApiManager
import com.obvious.nasapictures.data.model.api.ResultList
import io.reactivex.Observable
import javax.inject.Inject

class AppDatamanager : DataManager {

    val apiManager : ApiManager

    @Inject
    constructor(apiManager: ApiManager){
        this.apiManager =apiManager
    }

    override fun getImages(): Observable<ResultList> {
        return apiManager.getImages()
    }

}