package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Square
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

    lateinit var firstSquare : Square
    lateinit var secondSquare : Square
    lateinit var allSquares : List<Square>

    @BeforeEach
    fun setup() {
        firstSquare = Square(Point(0.0,0.0), Point(2.0, 2.0))
        secondSquare = Square(Point(3.0,3.0), Point(4.0, 4.0))

        firstSquare.uniqueId = "square1"
        secondSquare.uniqueId = "square2"

        allSquares = listOf(firstSquare, secondSquare)

        Mockito.`when`(shapeRepository.findAll()).thenReturn(allSquares)
    }

    @Test
    fun ensureGetAllSquaresServiceReturnsRepositoryResult() {

        val result = service.getAllSquares()
        val resultsEqual = result == allSquares

        Assertions.assertTrue(resultsEqual)
    }

    @Test
    fun findById() {
        Mockito.`when`(shapeRepository.findById("square2")).thenReturn(Optional.of(secondSquare))

        val result : Optional<Square> = service.findById("square2")

        Assertions.assertTrue(result.isPresent)
        Assertions.assertTrue(result.get().uniqueId == "square2")
    }

    @Test
    fun createSquare() {
    }
}