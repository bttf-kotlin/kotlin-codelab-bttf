package com.github.adrienpessu.kotlincodelabbttf

import com.github.kotlincodelabbttf.controllers.EventController
import com.github.kotlincodelabbttf.models.Event
import org.junit.Assert.assertEquals
import org.junit.Test

class LetterTest {

    @Test
    fun `1985 should return one thousand nine hundred and eighty five`() {
        val events = arrayListOf<Event>(Event("1985", "test", "test"))
        val event = (EventController.Letter.prettier(events) as List<Event>)[0]
        assertEquals(
            event.date
            , "one thousand nine hundred and eighty five")
    }

    @Test
    fun `1913 should return one thousand nine hundred and thirteen`() {
        val events = arrayListOf<Event>(Event("1913", "test", "test"))
        val event = (EventController.Letter.prettier(events) as List<Event>)[0]
        assertEquals(
            event.date
            , "one thousand nine hundred and thirteen")
    }

    @Test
    fun `When there is no date, nothing should be return`() {
        val events = arrayListOf<Event>(Event("", "test", "test"))
        val size = (EventController.Letter.prettier(events) as List<Event>).size

        assertEquals(
            size
            , 0)
    }


}
