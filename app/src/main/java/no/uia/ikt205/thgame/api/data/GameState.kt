package no.uia.ikt205.knotsandcrosses.api.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

typealias GameState = MutableList<MutableList<Int>>

@Parcelize
data class Game(val players:MutableList<String>, val gameId:String, val state:GameState ):Parcelable


