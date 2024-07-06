package ru.agniaendie.categoryservice.model


import jakarta.persistence.Id
import java.util.UUID

data class Category(@Id val uuid: String = UUID.randomUUID().toString(), val title: String, val hide: Int)