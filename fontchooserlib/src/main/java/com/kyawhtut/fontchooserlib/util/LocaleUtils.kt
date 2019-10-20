package com.kyawhtut.fontchooserlib.util

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*

class LocaleUtils private constructor(private val context: Context) {

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }

    fun updateResource(language: String): Context {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(language)
        } else updateResourcesLegacy(language)
    }

    class Builder(private val ctx: Context?) {

        fun build(): LocaleUtils {
            if (ctx == null) throw Exception("Context must not be null")
            return LocaleUtils(ctx)
        }
    }
}