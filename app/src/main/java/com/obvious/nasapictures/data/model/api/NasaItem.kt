package com.obvious.nasapictures.data.model.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaItem(
    @SerializedName("copyright")
    var copyright : String?,
    @SerializedName("date")
    var date : String,
    @SerializedName("explanation")
    var explanation: String,
    @SerializedName("hdurl")
    var hdurl: String,
    @SerializedName("media_type")
    var media_type: String,
    @SerializedName("service_version")
    var service_version: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
) : Parcelable