package com.github.kotlincodelabbttf.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Event(
    val date: String,
    @Id val title: String,
    val description: String
)