package com.github.kotlincodelabbttf.controllers

import com.github.kotlincodelabbttf.models.Event
import com.github.kotlincodelabbttf.reporitories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController {

    @Autowired
    lateinit var repository: EventRepository

    @GetMapping("/events")
    fun get(@RequestParam prettier: String?): Any =
        if (prettier == null) repository.findAll() else Letter.prettier(repository.findAll())

    companion object Letter {
        val unitsString = arrayOf(
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine"
        )

        fun prettier(events: List<Event>): Any {
            return events.filter { it.date.isNotEmpty()}.map {
                it.copy(date = """${unitsString[it.date[0].toString().toInt()]} ${unitsString[it.date[1].toString().toInt()]} ${unitsString[it.date[2].toString().toInt()]} ${unitsString[it.date[3].toString().toInt()]}""")
            }
        }
    }
}