package ru.agniaendie.categoryservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.agniaendie.categoryservice.dto.CategoryDTO
import ru.agniaendie.categoryservice.repository.CategoryRepository
import ru.agniaendie.categoryservice.mapping.CategoryMapper

@Service
class CategoryService(@Autowired private val categoryRepository: CategoryRepository, val mapper: CategoryMapper) {
    fun getAllCategories(): List<CategoryDTO> {
        val list = categoryRepository.findAll()
        return list.map { mapper.toDTO(it) }
    }
}