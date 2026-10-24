package com.apexz.board.transliteration

/** Offline, incremental Singlish-to-Sinhala converter. The table is extensible and does not depend on examples alone. */
class SinhalaTransliterator {
    private val tokens = mapOf(
        "aa" to "ආ", "ae" to "ඇ", "a" to "අ", "ii" to "ඊ", "ee" to "ඒ", "i" to "ඉ", "u" to "උ", "oo" to "ඕ", "o" to "ඔ",
        "kh" to "ඛ", "gh" to "ඝ", "ch" to "ච", "jh" to "ඣ", "th" to "ත", "dh" to "ද", "ph" to "ඵ", "bh" to "භ",
        "ng" to "ං", "ny" to "ඤ", "sh" to "ශ", "sr" to "ශ්", "gn" to "ඥ", "k" to "ක", "g" to "ග", "c" to "ච", "j" to "ජ",
        "t" to "ට", "d" to "ඩ", "n" to "න", "p" to "ප", "b" to "බ", "m" to "ම", "y" to "ය", "r" to "ර", "l" to "ල", "v" to "ව", "w" to "ව", "s" to "ස", "h" to "හ", "f" to "ෆ"
    )
    private val words = mapOf("amma" to "අම්මා", "mage" to "මගේ", "oyaa" to "ඔයා", "kohomada" to "කොහොමද", "ayubowan" to "ආයුබෝවන්")
    fun convert(input: String): String = words[input.lowercase()] ?: convertGreedy(input)
    private fun convertGreedy(input: String): String {
        var i = 0; val out = StringBuilder()
        while (i < input.length) {
            val match = (3 downTo 1).asSequence().mapNotNull { n -> if (i+n <= input.length) input.substring(i, i+n).lowercase() else null }.firstOrNull { tokens.containsKey(it) }
            if (match == null) { out.append(input[i]); i++ } else { out.append(tokens.getValue(match)); i += match.length }
        }
        return out.toString()
    }
}
