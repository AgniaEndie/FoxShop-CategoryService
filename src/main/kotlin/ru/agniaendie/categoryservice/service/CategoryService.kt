package ru.agniaendie.categoryservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.agniaendie.categoryservice.dto.CategoryDTO
import ru.agniaendie.categoryservice.dto.ResultRequest
import ru.agniaendie.categoryservice.entity.Category
import ru.agniaendie.categoryservice.repository.CategoryRepository
import ru.agniaendie.categoryservice.mapping.CategoryMapper

@Service
class CategoryService(@Autowired private val categoryRepository: CategoryRepository, val mapper: CategoryMapper) {
    fun getAllCategories(): ResultRequest<List<CategoryDTO>> {
        val list = categoryRepository.findAll()
        return ResultRequest.Success(list.map { mapper.toDTO(it) })
    }

    fun getCategory(categoryId: String): ResultRequest<CategoryDTO> {
        val category = categoryRepository.findCategoryByUuid(categoryId)
        return if (category != null) {
            ResultRequest.Success(mapper.toDTO(category))
        }else{
            ResultRequest.Failure("Category not found")
        }
    }

    fun addCategory(categoryDTO: CategoryDTO): ResultRequest<Category> {
        return ResultRequest.Success(categoryRepository.save(mapper.fromDTO(categoryDTO)))
    }

    fun updateCategory(categoryDTO: CategoryDTO): ResultRequest<CategoryDTO> {
        try{
            val category = categoryRepository.save(mapper.fromDTO(categoryDTO))
            return ResultRequest.Success(mapper.toDTO(category))
        }catch (e: Exception){
            return ResultRequest.Failure(e.message!!)
        }
    }

    fun deleteCategory(categoryUUID: String) {
        val category = categoryRepository.findCategoryByUuid(categoryUUID)
        if (category != null) {
            categoryRepository.delete(category)
        }
    }
}