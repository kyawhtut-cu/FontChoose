package com.kyawhtut.fontchooserlib.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import com.kyawhtut.fontchooserlib.FontChoose
import com.kyawhtut.fontchooserlib.util.toDisplay
import com.kyawhtut.fontchooserlib.util.toServer

class MMToolbar : Toolbar {
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setTitle(resId: Int) {
        super.setTitle(resources.getString(resId).toDisplay(FontChoose.isUnicode()))
    }

    override fun setTitle(title: CharSequence?) {
        super.setTitle(title.toDisplay(FontChoose.isUnicode()))
    }

    val mTitle: CharSequence
        get() = title.toServer(FontChoose.isUnicode())
}