package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Rectangle
import net.marksheehan.shape.backend.repository.ShapeRepository
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class ShapeServiceImplTest @Autowired constructor(){
    @MockBean
    private lateinit var shapeRepository: ShapeRepository

    @Autowired
    private lateinit var service: ShapeService

    lateinit var firstRectangle : Rectangle
    lateinit var secondRectangle : Rectangle
    lateinit var allRectangles : List<Rectangle>

    @BeforeEach
    fun setup() {
        firstRectangle = Rectangle(Point(0.0,0.0), Point(2.0, 2.0))
        secondRectangle = Rectangle(Point(3.0,3.0), Point(4.0, 4.0))

        firstRectangle.uniqueId = "square1"
        secondRectangle.uniqueId = "square2"

        allRectangles = listOf(firstRectangle, secondRectangle)

        Mockito.`when`(shapeRepository.findAll()).thenReturn(allRectangles)
    }

    @Test
    fun ensureGetAllSquaresServiceReturnsRepositoryResult() {

        val result = service.getAllSquares()
        val resultsEqual = result == allRectangles

        Assertions.assertTrue(resultsEqual)
    }

    @Test
    fun findById() {
        Mockito.`when`(shapeRepository.findById("square2")).thenReturn(Optional.of(secondRectangle))

        val result : Optional<Rectangle> = service.findById("square2")

        Assertions.assertTrue(result.isPresent)
        Assertions.assertTrue(result.get().uniqueId == "square2")
    }

    @Test
    fun createSquare() {
    }
}