package ru.agniaendie.categoryservice

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CategoryServiceApplication

val logger = LoggerFactory.getLogger(CategoryServiceApplication::class.java)

fun main(args: Array<String>) {
    runApplication<CategoryServiceApplication>(*args)
}
