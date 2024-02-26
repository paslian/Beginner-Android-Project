package com.example.proyek_android_pemula_pasliansahatrafael

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val photo: String,
    val name: String,
    val role: String,
    val description: String,
    val lane: String,
    val spell: String,
    val price: String,
    val releaseDate: String,
    val specialist: String,
    val imgSkin1: String,
    val imgSkin2: String,
    val imgSkin3: String,
    val imgItemRecommendation: String


) : Parcelable