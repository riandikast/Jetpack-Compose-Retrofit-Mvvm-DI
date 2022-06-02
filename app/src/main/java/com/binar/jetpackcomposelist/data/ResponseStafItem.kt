package com.binar.jetpackcomposelist.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseStafItem(
    @SerializedName("createdAt")
    val createdAt: String,


    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
):Parcelable