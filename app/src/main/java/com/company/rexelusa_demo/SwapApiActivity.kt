package com.company.rexelusa_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.company.rexelusa_demo.StarWarAPI.StarWars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://swapi.dev/api/"
val restURL: String? = null
const val TAG = "MainActivity"
private val client = OkHttpClient()

class SwapApiActivity : AppCompatActivity() {
    var textResultApi: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swap_api)


        // finding the button
        val showButton = findViewById<Button>(R.id.btnRequest)
        val BtnGoToHome = findViewById<Button>(R.id.btnGOHome)

        // finding the edit text
        val editURL = findViewById<EditText>(R.id.editGetUrl)
        textResultApi = findViewById<TextView>(R.id.resultAPI)


        //switch back to previous activity
        BtnGoToHome.setOnClickListener {

            val intent = Intent(this@SwapApiActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        // Setting On Click Listener
        showButton.setOnClickListener {

            // Getting the user input
            var text = editURL.text.toString()
            println("$text sent as query/url")
            //we will assume user will enter correct URL
            println("button clicked working")


            //here we can check if query is people get people
            //query is films we get films
            //query is planets we get planets

            //call url
            when {
                text.contains("people") -> getPeopleData()
             //   text.contains("films") -> getFilmData()
              //  text.contains("planets") -> getPlanetData()

                text == "" -> {
                    Toast.makeText(
                        applicationContext,
                        "Empty String! please try people/1,film/1, planet/1",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        applicationContext,
                        "Sorry this search is not avaialble right now! please try people,film, planet",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }// end listner

    }

    private fun getPeopleData() {
        var result: String = ""

        println("inside getCurrentData Method")
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWars::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getPeople().awaitResponse()
                if (response.isSuccessful) {

                    val data = response.body()!!
                    println("result /people/1:" + data.toString())
                    Log.d(TAG, data.toString())

                    withContext(Dispatchers.Main) {
/*                        for (i in data.indices) {
                            println(data[i].name)
                            result = result + data[i].name + "\n"

                        }*/
                        //finally set text to text view
                        textResultApi!!.setText("name:" + data.name + "\n" + "gender:" + data.gender + "\n" + "birth-year:" + data.birth_year)
                            .toString()


                    }

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        applicationContext,
                        "Seems like something went wrong...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }



 suspend  fun getPlanetData() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWars::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getPlanets().awaitResponse()
                if (response.isSuccessful) {

                    val data = response.body()!!
                    println("result /planets/1:" + data.toString())
                    Log.d(TAG, data.toString())

                    withContext(Dispatchers.Main) {
                        /*for (i in data.indices) {
                            println(data[i].name)
                            result = result + data[i].name + "\n"

                        }*/
                        //finally set text to text view
                        textResultApi!!.setText("planet name:" + data.name + "\n" + "diameter:" + data.diameter + "\n" + "climate:" + data.climate)
                            .toString()


                    }

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        applicationContext,
                        "Seems like something went wrong...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }






         fun getFilmData() {

            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StarWars::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = api.getFilms().awaitResponse()
                    if (response.isSuccessful) {

                        val data = response.body()!!
                        println("result /films/1:" + data.toString())
                        Log.d(TAG, data.toString())

                        withContext(Dispatchers.Main) {
/*                        for (i in data.indices) {
                            println(data[i].name)
                            result = result + data[i].name + "\n"

                        }*/
                            //finally set text to text view
                            textResultApi!!.setText("title:" + data.title + "\n" + "producer:" + data.producer + "\n" + "release-date:" + data.release_date)
                                .toString()


                        }

                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            applicationContext,
                            "Seems like something went wrong...",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }//end function

    }//end activity

}















