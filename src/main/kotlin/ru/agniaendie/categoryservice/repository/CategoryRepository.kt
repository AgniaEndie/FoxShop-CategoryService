package ru.agniaendie.categoryservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.agniaendie.categoryservice.entity.Category

interface CategoryRepository : JpaRepository<Category, String> {

}