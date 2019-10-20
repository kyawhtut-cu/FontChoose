package com.kyawhtut.fontchooserlib

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.kyawhtut.fontchooserlib.util.FontUtils
import com.kyawhtut.fontchooserlib.util.LocaleUtils
import kotlinx.android.synthetic.main.layout_font_chooser.*

class FontChoose private constructor(
    private val activity: AppCompatActivity,
    @DrawableRes private val logo: Int = R.drawable.ic_kagyi_letter,
    private val finish: Boolean = false
) : DialogFragment() {

    private val fontUtil by lazy {
        FontUtils.Builder(activity).build()
    }

    private var fontType: FontUtils.FontType = fontUtil.getUserFont()
    private var langType: FontUtils.LanguageType = fontUtil.getUserLanguage()

    companion object {
        private val TAG = FontChoose::class.java.name
        private var fontUtil: FontUtils? = null
        private var logo: Int = R.drawable.ic_kagyi_letter

        fun isUnicode(): Boolean {
            if (fontUtil == null) throw Exception("Please initialize FontChoose before use this value. FontChoose.init()")
            return fontUtil!!.isUnicode()
        }

        fun isZawgyi(): Boolean {
            if (fontUtil == null) throw Exception("Please initialize FontChoose before use this value. FontChoose.init()")
            return fontUtil!!.isZawgyi()
        }

        /*
        * finish for to finish activity.
        * If your press back action any choose, to finish activity.
        * If true activity will automatically finish.
        * If false Font and Language will choose automatically default.
        * Default Langauge is English and default font is Unicode.
        *
        * */
        fun init(activity: AppCompatActivity?, @DrawableRes logo: Int, finish: Boolean = false) {
            this.logo = logo
            if (activity == null) throw Exception("Activity must not be null")
            if (fontUtil == null) fontUtil = FontUtils.Builder(activity).build()
            if (fontUtil!!.isFirst)
                FontChoose(activity, logo, finish).show(activity.supportFragmentManager, TAG)
        }

        fun updateBaseContextLocale(context: Context?): Context {
            if (context == null) throw Exception("Context must not be null")
            return LocaleUtils.Builder(context).build()
                .updateResource(FontUtils.Builder(context).build().getResource())
        }

        fun change(activity: AppCompatActivity?, @DrawableRes logo: Int = this.logo) {
            if (activity == null) throw Exception("Activity must not be null")
            if (fontUtil == null) fontUtil = FontUtils.Builder(activity).build()
            FontChoose(activity, logo).show(activity.supportFragmentManager, TAG)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar)
        } else {
            setStyle(STYLE_NORMAL, android.R.style.Theme_DeviceDefault_Light_NoActionBar)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_font_chooser, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSelectedLanguage(if (langType is FontUtils.LanguageType.ENGLISH) rl_english else rl_myanmar)
        setSelectedFont(if (fontType is FontUtils.FontType.MM_UNICODE) iv_unicode_check else iv_zawgyi_check)

        iv_app_logo.setImageResource(logo)

        rl_english.setOnClickListener {
            langType = FontUtils.LanguageType.ENGLISH
            setSelectedLanguage(rl_english)
        }

        rl_myanmar.setOnClickListener {
            langType = FontUtils.LanguageType.MYANMAR
            setSelectedLanguage(rl_myanmar)
        }

        rl_unicode.setOnClickListener {
            fontType = FontUtils.FontType.MM_UNICODE
            setSelectedFont(iv_unicode_check)
        }

        rl_zawgyi.setOnClickListener {
            fontType = FontUtils.FontType.MM_ZAWGYI
            setSelectedFont(iv_zawgyi_check)
        }

        btn_next.setOnClickListener {
            fontUtil.apply {
                isFirst = false
                set(langType, fontType)
            }
            LocaleUtils.Builder(activity).build().apply {
                updateResource(fontUtil.getResource())
            }
            activity.finish()
            startActivity(activity.intent)
        }
    }

    private fun setSelectedLanguage(view: View) {
        rl_english.isSelected = false
        rl_myanmar.isSelected = false

        view.isSelected = true
    }

    private fun setSelectedFont(view: View) {
        iv_unicode_check.visibility = View.INVISIBLE
        iv_zawgyi_check.visibility = View.INVISIBLE

        view.visibility = View.VISIBLE
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(getActivity()!!, theme) {
            override fun onBackPressed() {
                if (fontUtil.isFirst)
                    if (finish) activity.finish()
                    else {
                        dismiss()
                        AlertDialog.Builder(activity).apply {
                            setTitle("Font chooser")
                            setMessage("If you choose any font type. Default Font is Unicode English.")
                            setCancelable(false)
                            setPositiveButton("Ok") { dialog, _ ->
                                fontUtil.set(langType, fontType)
                                dialog.dismiss()
                            }
                        }.show()
                    }
                else
                    dismiss()
            }
        }
    }
}