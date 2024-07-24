package ru.agniaendie.categoryservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CategoryServiceApplication

val logger: Logger = LoggerFactory.getLogger(CategoryServiceApplication::class.java)

fun main(args: Array<String>) {
    runApplication<CategoryServiceApplication>(*args)
}
