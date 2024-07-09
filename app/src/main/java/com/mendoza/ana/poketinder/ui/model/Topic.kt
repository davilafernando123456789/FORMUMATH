package com.mendoza.ana.poketinder.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic(
    val title: String,
    val definition: String,
    val terms: String,
    val description: String
) : Parcelable
