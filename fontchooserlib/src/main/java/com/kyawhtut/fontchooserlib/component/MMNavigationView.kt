package com.kyawhtut.fontchooserlib.component

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.navigation.NavigationView
import com.kyawhtut.fontchooserlib.FontChoose
import com.kyawhtut.fontchooserlib.util.toDisplay

class MMNavigationView : NavigationView {
    constructor(context: Context?) : super(context) {
        changeMMMenu()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        changeMMMenu()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        changeMMMenu()
    }

    private fun changeMMMenu() {
        for (i in 0 until menu.size()) {
            menu.getItem(i).title = menu.getItem(i).title.toDisplay(FontChoose.isUnicode())
            if (menu.getItem(i).hasSubMenu())
                for (j in 0 until menu.getItem(i).subMenu.size()) {
                    menu.getItem(i).subMenu.getItem(j).title =
                        menu.getItem(i).subMenu.getItem(j).title.toDisplay(FontChoose.isUnicode())
                }
        }
    }
}