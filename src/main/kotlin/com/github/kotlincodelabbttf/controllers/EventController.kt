package com.github.kotlincodelabbttf.controllers

import com.github.kotlincodelabbttf.models.Event
import com.github.kotlincodelabbttf.reporitories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController() {

    @Autowired
    lateinit var repository: EventRepository

    @GetMapping("/events")
    fun get(): Any = Letter.prettier(repository.findAll())

    companion object Letter {

        fun prettier(events: List<Event>): Any =events.filter { it.date.isNotEmpty() }

    }
}