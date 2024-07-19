package ru.agniaendie.categoryservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.agniaendie.categoryservice.dto.CategoryDTO
import ru.agniaendie.categoryservice.dto.ResultRequest
import ru.agniaendie.categoryservice.entity.Category
import ru.agniaendie.categoryservice.exception.DataNotFoundException
import ru.agniaendie.categoryservice.repository.CategoryRepository
import ru.agniaendie.categoryservice.mapping.CategoryMapper

@Service
class CategoryService(@Autowired private val categoryRepository: CategoryRepository, val mapper: CategoryMapper) {
    fun getAllCategories(): List<CategoryDTO> {
        val list = categoryRepository.findAll()
        return list.map { mapper.toDTO(it) }
    }

    fun getCategory(categoryId: String): CategoryDTO {
        val category = categoryRepository.findCategoryByUuid(categoryId)
        if(category != null) {
            return mapper.toDTO(category)
        }else{
            throw DataNotFoundException("Category not found")
        }
    }

    fun addCategory(categoryDTO: CategoryDTO): ResultRequest<Category> {
        return ResultRequest.Success(categoryRepository.save(mapper.fromDTO(categoryDTO)))
    }

    fun updateCategory(categoryDTO: CategoryDTO): CategoryDTO {
        val category = categoryRepository.save(mapper.fromDTO(categoryDTO))
        return mapper.toDTO(category)
    }

    fun deleteCategory(categoryUUID: String) {
        val category = categoryRepository.findCategoryByUuid(categoryUUID)
        if (category != null) {
            categoryRepository.delete(category)
        }else{
            throw DataNotFoundException("Category not found")
        }
    }
}