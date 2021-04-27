package com.gisc.track.util

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

object SharedPrefsUtil {

    const val CATCH_POKEMON = "CATCH_POKEMON"

    fun getString(context: Context, key: String): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(key, null)
    }

    fun setString(context: Context, key: String, value: String): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (key.isNotEmpty()) {
            preferences.edit {
                putString(key, value)
            }
            return true
        }
        return false
    }

    fun remove(context: Context, key: Array<String>) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        for (k in key){
            editor.remove(k)
        }
        editor.apply()
    }

    fun clear(context: Context){
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}