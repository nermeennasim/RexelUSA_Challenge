package com.company.rexelusa_demo.StarWarAPI

import retrofit2.Retrofit


public class StarWarsApi {

    private var mSwApi: StarWars? = null
    private var sInstance: StarWarsApi? = null


    fun init() {
        sInstance = StarWarsApi()
    }

    fun getApi(): StarWars? {
        return sInstance!!.mSwApi
    }

    fun setApi(starWarsApi: StarWars?) {
        sInstance!!.mSwApi = starWarsApi
    }

}