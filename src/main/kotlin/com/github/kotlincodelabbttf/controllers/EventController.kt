package com.github.kotlincodelabbttf.controllers

import com.github.kotlincodelabbttf.reporitories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController() {

    @Autowired
    lateinit var repository: EventRepository

    @GetMapping("/events")
    fun get(): Any = repository.findAll()
}