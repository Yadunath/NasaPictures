package com.obvious.nasapictures.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.obvious.nasapictures.RxImmediateSchedulerRule
import com.obvious.nasapictures.data.DataManager
import com.obvious.nasapictures.data.model.api.NasaItem
import com.obvious.nasapictures.data.model.api.ResultList
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import kotlin.collections.ArrayList

class HomeViewModelTest{

    @Rule @JvmField
    var instant = InstantTaskExecutorRule()

    @Rule @JvmField
    val rule = MockitoJUnit.rule()!!
    @Rule
    @JvmField var testSchedulerRule = RxImmediateSchedulerRule()

    lateinit var viewModel :HomeViewModel

    private lateinit var dataManager: DataManager

    @Before
    fun setUp(){
        dataManager = mock(DataManager::class.java)
        viewModel = HomeViewModel(dataManager)
    }

    @Test
    fun testFetchData(){
        var result =  ArrayList<NasaItem>();
        result.add(NasaItem("","","","","","","title",""))
        var resultList = ResultList(result);
        doReturn(Observable.just(resultList)).`when`(dataManager).getImages()
        viewModel.getListOfImages()
        viewModel.getLiveData().observeForever{}
    }
}


