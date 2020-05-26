package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.repository.ShapeRepository
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@WebMvcTest
internal class ShapeControllerTest @Autowired constructor(
) {
    @Configuration
    class SpringConfig {

        @MockBean
        private lateinit var shapeRepository: ShapeRepository

//        @Bean
//        fun  shapeService() : ShapeService
//        {
//            return ShapeServiceImpl(shapeRepository)
//        }
    }

//    @Autowired
//    private lateinit var shapeService: ShapeServiceImpl

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
//        shapeService = ShapeServiceImpl(shapeRepository)
    }
//    @MockBean
//    private var shapeService : ShapeService? = null

//    @Autowired
//    lateinit var mockMvc: MockMvc

//    @MockBean
//    private val toDoService: ToDoService? = null

    @Test
    fun getShape() {
//        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello,

        val resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/shape")
                .contentType(MediaType.APPLICATION_JSON))

        resultActions.andExpect(jsonPath("$", Matchers.hasSize<Any>(2)))
                .andExpect(status().isOk)
                .andExpect(content().string(Matchers.containsString("hi")))
//                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getAllShapes() {
        val resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/shapes")
                .contentType(MediaType.APPLICATION_JSON))

        resultActions.andExpect(jsonPath("$", Matchers.hasSize<Int>(1)))
                .andExpect(jsonPath("$[0].name", Matchers.`is`("alex.getName()")))
                .andExpect(status().isOk)
                .andExpect(content().string(Matchers.containsString("hi")))
//                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun postShape() {
    }

    @Test
    fun greeting() {
    }
}