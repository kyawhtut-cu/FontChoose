package com.kyawhtut.fontchooserlib.util

import org.rabbitconverter.rabbit.Rabbit

fun String.toZawgyi() = Rabbit.uni2zg(this)

fun String.toUni() = Rabbit.zg2uni(this)

fun String.toDisplay(isUnicode: Boolean) = if (isUnicode) this else this.toZawgyi()

fun String.toServer(isUnicode: Boolean) = if (isUnicode) this else this.toUni()

fun CharSequence?.toZawgyi() = this.toString().toZawgyi()

fun CharSequence?.toUni() = this.toString().toUni()

fun CharSequence?.toDisplay(isUnicode: Boolean) =
    this.toString().toDisplay(isUnicode)

fun CharSequence?.toServer(isUnicode: Boolean) =
    this.toString().toServer(isUnicode)

fun Iterable<String>.toZawgyi(): List<String> {
    return ArrayList<String>().apply {
        this@toZawgyi.map {
            this.add(it.toZawgyi())
        }
    }
}

fun Iterable<String>.toUni(): List<String> {
    return ArrayList<String>().apply {
        this@toUni.map {
            this.add(it.toUni())
        }
    }
}

fun Iterable<String>.toDisplay(isUnicode: Boolean): List<String> {
    return ArrayList<String>().apply {
        this@toDisplay.map {
            this.add(it.toDisplay(isUnicode))
        }
    }
}

fun Iterable<String>.toServer(isUnicode: Boolean): List<String> {
    return ArrayList<String>().apply {
        this@toServer.map {
            this.add(it.toServer(isUnicode))
        }
    }
}