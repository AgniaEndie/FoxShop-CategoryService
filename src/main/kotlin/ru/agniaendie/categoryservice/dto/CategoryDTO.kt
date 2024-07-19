package ru.agniaendie.categoryservice.dto

import java.io.Serializable
import java.util.*

data class CategoryDTO(
    var uuid: String = UUID.randomUUID().toString(), var title: String, var hide: Boolean
) : Serializable
