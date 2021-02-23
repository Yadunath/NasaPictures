package com.obvious.nasapictures.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.obvious.nasapictures.R
import com.obvious.nasapictures.data.model.api.NasaItem
import com.obvious.nasapictures.ui.util.Constants

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var nasaItem = intent.getParcelableExtra<NasaItem>(Constants.KEY)
        var imageView: ImageView = findViewById(R.id.imageView)
        var textView = findViewById<TextView>(R.id.textView)
        var textViewDescription = findViewById<TextView>(R.id.details)

        Glide.with(imageView).load(nasaItem?.url)
            .centerCrop()
            .into(imageView)
        textView.text = nasaItem?.title
        textViewDescription.text = nasaItem?.explanation

    }
}