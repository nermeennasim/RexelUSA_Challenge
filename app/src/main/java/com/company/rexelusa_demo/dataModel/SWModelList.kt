package com.company.rexelusa_demo.dataModel

import android.text.TextUtils
import java.io.Serializable


class SWModelList<T> : Serializable {
    var count = 0
    var next: String? = null
    var previous: String? = null
    var results: ArrayList<T>? = null
    fun hasMore(): Boolean {
        return !TextUtils.isEmpty(next)
    }

}