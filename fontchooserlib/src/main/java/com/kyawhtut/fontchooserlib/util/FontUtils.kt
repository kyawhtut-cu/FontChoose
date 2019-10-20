package com.kyawhtut.fontchooserlib.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class FontUtils private constructor(private val sh: SharedPreferences) {

    companion object {
        private const val KEY_SH = "font.xml"
        private const val KEY_LANG = "userLang"
        private const val KEY_FONT = "userFont"
        private const val KEY_FIRST = "keyFirst"
    }

    var isFirst: Boolean = true
        set(value) {
            field = value
            sh.edit().putBoolean(KEY_FIRST, value).apply()
        }
        get() = sh.getBoolean(KEY_FIRST, true)

    fun getResource() = if (getUserLanguage() is LanguageType.ENGLISH) "en" else "my"

    fun setFont(fontType: FontType) {
        if (fontType.key !in 0..1) throw Exception("Please provide Font Type. Invalid Font.")
        sh.edit().putInt(KEY_FONT, fontType.key).apply()
    }

    fun setLanguage(langType: LanguageType) {
        if (langType.key !in 0..1) throw Exception("Please provide Language Type. Invalid Language.")
        sh.edit().putInt(KEY_LANG, langType.key).apply()
    }

    fun set(langType: LanguageType, fontType: FontType) {
        setFont(fontType)
        setLanguage(langType)
    }

    fun getUserFont(): FontType = when (sh.getInt(KEY_FONT, 0)) {
        0 -> FontType.MM_UNICODE
        else -> FontType.MM_ZAWGYI
    }

    fun getUserLanguage(): LanguageType = when (sh.getInt(KEY_LANG, 0)) {
        0 -> LanguageType.ENGLISH
        else -> LanguageType.MYANMAR
    }

    fun isEnglish() = getUserLanguage() is LanguageType.ENGLISH

    fun isMyanmar() = getUserLanguage() is LanguageType.MYANMAR

    fun isUnicode() = getUserFont() is FontType.MM_UNICODE

    fun isZawgyi() = getUserFont() is FontType.MM_ZAWGYI

    class Builder(private val context: Context?) {

        fun build(): FontUtils {
            if (context == null) throw Exception("Context must not be null")
            return FontUtils(context.getSharedPreferences(KEY_SH, MODE_PRIVATE))
        }
    }

    sealed class LanguageType(val key: Int) {
        object ENGLISH : LanguageType(0)
        object MYANMAR : LanguageType(1)
    }

    sealed class FontType(val key: Int) {
        object MM_UNICODE : FontType(0)
        object MM_ZAWGYI : FontType(1)
    }
}