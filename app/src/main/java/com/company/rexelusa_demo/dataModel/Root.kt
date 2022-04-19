package com.company.rexelusa_demo.dataModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Root : Serializable {
    @SerializedName("films")
    var filmsUrl: String? = null

    @SerializedName("people")
    var peopleUrl: String? = null

    @SerializedName("planets")
    var planetsUrl: String? = null

    @SerializedName("species")
    var speciesUrl: String? = null

    @SerializedName("starships")
    var starshipsUrl: String? = null

    @SerializedName("vehicles")
    var vehiclesUrl: String? = null
}