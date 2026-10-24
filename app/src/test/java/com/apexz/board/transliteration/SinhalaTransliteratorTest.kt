package com.apexz.board.transliteration
import org.junit.Assert.assertEquals
import org.junit.Test
class SinhalaTransliteratorTest { private val t = SinhalaTransliterator()
    @Test fun commonWords() { assertEquals("අම්මා", t.convert("amma")); assertEquals("මගේ", t.convert("mage")); assertEquals("ඔයා", t.convert("oyaa")); assertEquals("කොහොමද", t.convert("kohomada")); assertEquals("ආයුබෝවන්", t.convert("ayubowan")) }
    @Test fun unknownCharactersPreserved() { assertEquals("123", t.convert("123")) }
}
