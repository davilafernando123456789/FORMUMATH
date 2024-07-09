package com.mendoza.ana.poketinder.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Subject(
    val title: String,
    val description: String,
    val amount: String,
    val topics: List<Topic>,
    val isFavorite: Boolean = false,
    val imageUrl: Int,
    //val imageUrl: String // Nuevo campo para la URL de la imagen
) : Parcelable
