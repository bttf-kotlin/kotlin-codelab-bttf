package com.github.adrienpessu.kotlincodelabbttf

import com.github.kotlincodelabbttf.controllers.EventController
import com.github.kotlincodelabbttf.models.Event
import org.junit.Assert.assertEquals
import org.junit.Test

class LetterTest {

    @Test
    fun `1985 should return one nine eight five`() {
        val testedDate = "1985"

        val events = arrayListOf<Event>(Event(testedDate, "test", "test"))
        val event = (EventController.Letter.prettier(events) as List<Event>)[0]
        assertEquals(
            event.date
            , "one nine eight five")
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