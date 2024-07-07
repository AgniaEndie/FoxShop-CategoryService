package ru.agniaendie.categoryservice.mapping

import org.springframework.stereotype.Component
import ru.agniaendie.categoryservice.dto.CategoryDTO
import ru.agniaendie.categoryservice.entity.Category

@Component
class CategoryMapper {
    fun toDTO(category: Category): CategoryDTO {
        return CategoryDTO(category.uuid, category.title, category.hide)
    }

    fun fromDTO(categoryDTO: CategoryDTO): Category {
        val category = Category()
        category.uuid = categoryDTO.uuid.toString()
        category.title = categoryDTO.title
        category.hide = categoryDTO.hide
        return category
    }
}