package ru.agniaendie.categoryservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*
import ru.agniaendie.categoryservice.dto.CategoryDTO
import ru.agniaendie.categoryservice.dto.ResultRequest
import ru.agniaendie.categoryservice.entity.Category
import ru.agniaendie.categoryservice.logger
import ru.agniaendie.categoryservice.service.CategoryService

@RestController
@RequestMapping("/api/category")
class CategoryController(@Autowired val categoryService: CategoryService) {
    @GetMapping("/all")
    suspend fun getAllCategory(): List<CategoryDTO> {
        return categoryService.getAllCategories()
    }

    @GetMapping("/get/{id}")
    @Cacheable(key = "#categoryId", value = ["CategoryDTO"], )
    fun getCategory(@PathVariable(value = "id") categoryId: String): CategoryDTO {
        return categoryService.getCategory(categoryId)
    }

    @GetMapping("/test")
    fun testAllCategory(): ResultRequest<List<CategoryDTO>> {
        return ResultRequest.Success(listOf())
    }

    @PostMapping("/add")
    fun addCategory(@RequestBody categoryDTO: CategoryDTO): ResultRequest<Category> {
        return categoryService.addCategory(categoryDTO)
    }

    @PutMapping("/update")
    fun updateCategory(@RequestBody categoryDTO: CategoryDTO): CategoryDTO {
        return categoryService.updateCategory(categoryDTO)
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(key = "#categoryId",value = ["CategoryDTO"])
    fun deleteCategory(@PathVariable(value = "id") categoryId: String) {
        return categoryService.deleteCategory(categoryId)
    }
}