package com.obvious.nasapictures.data.local

import android.util.Log
import com.obvious.nasapictures.data.model.api.ResultList
import io.reactivex.Observable
import javax.inject.Inject

class GsonApiManager : ApiManager {

    var gson : ResultList

    @Inject
    constructor(resultList:ResultList){
        Log.d("TAG",""+resultList.toString())
        gson = resultList
    }

    override fun getImages(): Observable<ResultList> {
        return Observable.create { emitter ->
            emitter.onNext(gson)
        }
    }
}


