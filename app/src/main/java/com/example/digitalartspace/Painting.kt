package com.example.digitalartspace
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Painting(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceid: Int,
)
