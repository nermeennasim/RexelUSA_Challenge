package com.company.rexelusa_demo.StarWarAPI

import kotlin.Throws
import android.os.Build
import okhttp3.Request
import java.io.IOException
import java.net.HttpURLConnection

class StarWarsOKClient {
    fun StarWarsOkClient() {

    }

    @Throws(IOException::class)
    protected fun openConnection(request: Request?): HttpURLConnection {
        val connection: HttpURLConnection = openConnection(request)
        connection.setRequestProperty("User-Agent", "swapi-android-" + Build.VERSION.RELEASE)
        return connection
    }
}