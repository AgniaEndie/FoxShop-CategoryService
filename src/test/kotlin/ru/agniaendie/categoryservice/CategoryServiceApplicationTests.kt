package ru.agniaendie.categoryservice

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.TestPropertySource
import ru.agniaendie.categoryservice.entity.Category
import ru.agniaendie.categoryservice.repository.CategoryRepository
import ru.agniaendie.categoryservice.service.CategoryService
import java.util.*

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class CategoryServiceApplicationTests {

    @Autowired
    private lateinit var categoryService: CategoryService

    @MockBean
    private lateinit var categoryRepository: CategoryRepository

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun isCategoryNotEmpty() {
        Mockito.`when`(categoryRepository.findAll()).thenReturn(
            listOf(
                Category(UUID.randomUUID().toString(), "test", true),
                Category(UUID.randomUUID().toString(), "test1", false)
            )
        )
        val categories = categoryService.getAllCategories()
        assertTrue(categories.isNotEmpty())
    }

}
