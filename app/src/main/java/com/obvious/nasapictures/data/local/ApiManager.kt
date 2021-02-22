package com.obvious.nasapictures.data.local

import com.obvious.nasapictures.data.model.api.ResultList
import io.reactivex.Observable

interface ApiManager{
    fun getImages() : Observable<ResultList>
}