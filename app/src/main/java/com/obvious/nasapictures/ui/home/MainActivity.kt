package com.obvious.nasapictures.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obvious.nasapictures.NasaApplication
import com.obvious.nasapictures.R
import com.obvious.nasapictures.data.model.api.NasaItem
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory : HomeViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NasaApplication).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadImages()
    }

    fun loadImages(){
        homeViewModel = ViewModelProvider(this,viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getListOfImages()
    }
}