package com.kyawhtut.fontchooserlib.component

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.kyawhtut.fontchooserlib.FontChoose
import com.kyawhtut.fontchooserlib.util.toDisplay
import com.kyawhtut.fontchooserlib.util.toServer

class MMMaterialButton : MaterialButton {

    constructor(context: Context?) : super(context) {
        mText = text
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mText = text
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mText = text
    }

    var mText: CharSequence?
        set(value) {
            text = value.toDisplay(FontChoose.isUnicode())
        }
        get() = text.toServer(FontChoose.isUnicode())
}