package ru.agniaendie.categoryservice.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "category")
class Category(
    @Id
    var uuid: String = UUID.randomUUID().toString(),
    var title: String = "",
    var hide: Boolean = false
)