package com.example.continentsrecyclereview

import android.os.Parcelable
import java.io.Serializable

data class Continent(
    val image: String,
    val title: String
): Serializable
