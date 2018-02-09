package com.github.kotlincodelabbttf.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Event(
    val date: String,
    @Id val title: String,
    val description: String
)