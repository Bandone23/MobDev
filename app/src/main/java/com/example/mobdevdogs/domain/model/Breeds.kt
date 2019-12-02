package com.example.mobdevdogs.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Breeds (
    var message:List<String>,
    val status :String
): Parcelable


