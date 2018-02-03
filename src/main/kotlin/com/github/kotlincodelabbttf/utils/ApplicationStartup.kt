package com.github.kotlincodelabbttf.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kotlincodelabbttf.models.Event
import com.github.kotlincodelabbttf.reporitories.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import java.io.File


@Component
class ApplicationStartup : ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    lateinit var repository: EventRepository

    override fun onApplicationEvent(event: ApplicationReadyEvent) {

        val json: String = File(javaClass.getResource("events.json").path)
            .inputStream().bufferedReader()
            .use { it.readText() }

        val mapper = ObjectMapper().registerModule(KotlinModule())
        val events: List<Event> = mapper.readValue(json)
        events.forEach { repository.save(it) }
    }

}