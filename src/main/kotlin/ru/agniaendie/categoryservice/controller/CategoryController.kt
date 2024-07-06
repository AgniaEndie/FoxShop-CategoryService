package ru.agniaendie.categoryservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.agniaendie.categoryservice.model.Category
import ru.agniaendie.categoryservice.service.CategoryService

@RestController
@RequestMapping("/api/category")
class CategoryController(@Autowired val categoryService: CategoryService) {
    @GetMapping("/all")
    suspend fun getAllCategory(): List<Category> {
        return categoryService.getAllCategories()
    }

}