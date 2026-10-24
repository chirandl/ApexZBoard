package com.apexz.board.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import com.apexz.board.transliteration.SinhalaTransliterator

class ApexZInputMethodService : InputMethodService() {
    private var shift = false
    private var phonetic = false
    private val transliterator = SinhalaTransliterator()
    override fun onCreateInputView(): View = KeyboardView(this) { handle(it) }
    private fun ic(): InputConnection? = currentInputConnection
    private fun handle(key: String) {
        when (key) {
            "⌫" -> ic()?.deleteSurroundingText(1, 0)
            "↵" -> ic()?.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_ENTER))
            "space" -> ic()?.commitText(" ", 1)
            "⇧" -> shift = !shift
            "🌐" -> phonetic = !phonetic
            else -> { val text = if (shift) key.uppercase() else key; ic()?.commitText(if (phonetic) transliterator.convert(text) else text, 1); shift = false }
        }
    }
    override fun onStartInput(info: EditorInfo?, restarting: Boolean) { super.onStartInput(info, restarting); shift = false }
}
