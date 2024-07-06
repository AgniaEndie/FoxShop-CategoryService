package ru.agniaendie.categoryservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.agniaendie.categoryservice.model.Category

interface CategoryRepository : JpaRepository<Category, String> {

}