package com.apexz.board.keyboard

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class KeyboardView(context: Context, private val onKey: (String) -> Unit) : LinearLayout(context) {
    private val rows = listOf("qwertyuiop", "asdfghjkl", "zxcvbnm")
    init { orientation = VERTICAL; setPadding(6, 6, 6, 6); render() }
    private fun render() {
        rows.forEach { chars ->
            val row = LinearLayout(context).apply { orientation = HORIZONTAL; gravity = Gravity.CENTER; layoutParams = LayoutParams(-1, 0, 1f) }
            chars.forEach { ch -> row.addView(key(ch.toString())) }; addView(row)
        }
        val bottom = LinearLayout(context).apply { orientation = HORIZONTAL; gravity = Gravity.CENTER; layoutParams = LayoutParams(-1, 0, 1f) }
        listOf("⇧", "🌐", "space", "⌫", "↵").forEach { bottom.addView(key(it, if (it == "space") 3f else 1f)) }; addView(bottom)
    }
    private fun key(label: String, weight: Float = 1f): View = Button(context).apply {
        text = label; textSize = 16f; isAllCaps = false; setTextColor(Color.rgb(23,50,77)); background = GradientDrawable().apply { setColor(Color.WHITE); cornerRadius = 18f; setStroke(1, Color.rgb(226,238,247)) }
        layoutParams = LayoutParams(0, -1, weight).apply { setMargins(3, 3, 3, 3) }; setOnClickListener { onKey(label) }
    }
}
