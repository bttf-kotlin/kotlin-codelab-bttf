package com.github.kotlincodelabbttf.reporitories

import com.github.kotlincodelabbttf.models.Event
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : CrudRepository<Event, String> {
    override fun findAll(): List<Event>
}