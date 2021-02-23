package com.obvious.nasapictures.ui.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.obvious.nasapictures.R
import com.obvious.nasapictures.data.model.api.NasaItem
import com.obvious.nasapictures.data.model.api.ResultList
import com.obvious.nasapictures.ui.details.DetailsActivity
import com.obvious.nasapictures.ui.util.Constants

class GridAdapter(private val result: List<NasaItem>) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.list_item, false)
        return ViewHolder(inflatedView)
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var nasaItem = result.get(position)
        Glide.with(holder.itemView).load(nasaItem.url)
            .centerCrop()
            .into(holder.imageView)
        holder.itemView.setOnClickListener { view ->
            var intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra(Constants.KEY, nasaItem)
            view.context.startActivity(intent)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = view.findViewById<ImageView>(R.id.imageView)

    }

}