package com.koushik.viewcounter_library

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class ViewCounter private constructor() {
    companion object {
        private var instance: ViewCounter? = null
        @JvmStatic
        fun getInstance(): ViewCounter {
            return instance ?: synchronized(this) {
                instance ?: ViewCounter().also { instance = it }
            }
        }
    }
    fun showViewCount(context: Context, rootView: View) {
        val viewCount = countViews(rootView)
        showToast(context, "Number of Views: $viewCount")
    }
    public fun countViews(view: View): Int {
        var count = 1 // Counting the root view
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                Log.d("VIEWCOUNT","${view.childCount}")
                count += countViews(child)
            }
        }
        return count
    }
    public fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}