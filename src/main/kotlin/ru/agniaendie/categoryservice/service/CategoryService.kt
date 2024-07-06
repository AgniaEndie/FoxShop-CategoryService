package ru.agniaendie.categoryservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.agniaendie.categoryservice.model.Category
import ru.agniaendie.categoryservice.repository.CategoryRepository

@Service
class CategoryService(@Autowired private val categoryRepository: CategoryRepository) {
    fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }
}