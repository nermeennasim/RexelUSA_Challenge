package com.company.rexelusa_demo.StarWarAPI

import com.company.rexelusa_demo.dataModel.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface StarWars {



   //****working method**********
    @GET("people/1")
    fun getPeople(): Call<PeopleDataModel>

    @GET("/films/1")
    fun getFilms(): Call<FilmsDataModel>

    @GET("/planet/1")
    fun getPlanets(): Call<PlanetsDataModel>

    /*
    @GET("/")
    fun getRootUrls(callback: Call<List<Root>>)

    @GET("/people/")
    fun getAllPeople(
        @Query("page") page: Int,
        callback: Call<List<People>>
    )

    @GET("/people/{id}/")
    fun getPeople(
        @Path("id") peopleId: Int,
        callback: Call<List<People>>
    )

    @GET("/films/")
    fun getAllFilms(
        @Query("page") page: Int,
        callback: Call<List<Film?>?>?
    )

    @GET("/films/{id}/")
    fun getFilm(
        @Path("id") filmId: Int,
        callback: Call<Film?>?
    )

    @GET("/planets/")
    fun getAllPlanets(
        @Query("page") page: Int,
        callback: Call<List<Planet>>?
    )

    @GET("/planets/{id}/")
    fun getPlanet(
        @Path("id") planetId: Int,
        callback: Call<List<Planet>>
    )


*/

}