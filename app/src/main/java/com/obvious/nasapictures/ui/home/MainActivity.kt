package com.obvious.nasapictures.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obvious.nasapictures.NasaApplication
import com.obvious.nasapictures.R
import com.obvious.nasapictures.data.model.api.NasaItem
import com.obvious.nasapictures.ui.adapter.GridAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    lateinit var homeViewModel: HomeViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GridAdapter

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NasaApplication).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        fetchImageList()
        observeForData()
    }

    fun fetchImageList() {
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getListOfImages()
    }

    fun setView() {
        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager =
            GridLayoutManager(applicationContext, 3, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
    }

    fun observeForData() {
        homeViewModel.getLiveData().observe(this,
            Observer { result ->
                adapter = GridAdapter(result.result)
                recyclerView.adapter = adapter
            })
    }
}