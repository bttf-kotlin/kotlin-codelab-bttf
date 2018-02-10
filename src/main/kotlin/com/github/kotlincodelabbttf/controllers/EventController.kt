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
            "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
        )

        val tenthString = arrayOf(
            "", "", "twenty", "thirty", "fourty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
        )

        val hundredsString = arrayOf(
            "", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred",
            "six hundred", "seven hundred", "eight hundred", "nine hundred"
        )

        val thousandsString = arrayOf(
            "", "one thousand", "two thousand", "three thousand", "four thousand", "five thousand", "six thousand",
            "seven thousand", "eight thousand", "nine thousand", "ten thousand"
        )

        fun prettier(events: List<Event>): Any {
            return events.filter { it.date.isNotEmpty() && it.date.length == 4 }
                .map {
                    val tenthAndUnit: String = when ("""${it.date[2]}${it.date[3]}""".toInt()) {
                        in 0..19 -> unitsString["""${it.date[2]}${it.date[3]}""".toInt()]
                        else -> """${tenthString[it.date[2].toString().toInt()]} ${unitsString[it.date[3].toString().toInt()]}"""
                    }

                    it.copy(date = """${thousandsString[it.date[0].toString().toInt()]} ${hundredsString[it.date[1].toString().toInt()]} and $tenthAndUnit""")
                }

        }
    }
}