package com.mendoza.ana.poketinder.util

import android.os.Bundle
import android.os.Parcelable

fun <T : Parcelable> T.toBundle(key: String): Bundle {
    return Bundle().apply {
        putParcelable(key, this@toBundle)
    }
}

inline fun <reified T : Parcelable> Bundle.getParcelable(key: String): T? {
    return getParcelable(key)
}
