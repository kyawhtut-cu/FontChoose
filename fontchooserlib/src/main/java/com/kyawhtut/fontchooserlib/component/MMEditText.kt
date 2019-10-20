package com.kyawhtut.fontchooserlib.component

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import com.kyawhtut.fontchooserlib.FontChoose
import com.kyawhtut.fontchooserlib.util.toDisplay
import com.kyawhtut.fontchooserlib.util.toServer

class MMEditText : EditText {
    constructor(context: Context?) : super(context) {
        if (hint != null) mHint = hint
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        if (hint != null) mHint = hint
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        if (hint != null) mHint = hint
    }

    var mHint: CharSequence
        set(value) {
            hint = value.toDisplay(FontChoose.isUnicode())
        }
        get() = hint.toServer(FontChoose.isUnicode())

    val mText: String
        get() = text.toServer(FontChoose.isUnicode())
}