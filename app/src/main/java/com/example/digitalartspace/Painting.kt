package com.example.digitalartspace
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Painting(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val year:Int,
    @DrawableRes val imageResourceid: Int,
)
