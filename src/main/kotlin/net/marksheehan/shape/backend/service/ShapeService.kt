package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Square
import java.util.*

data class CreateShapeResponse(val success : Boolean, val message : String, val id : String?)

interface ShapeService {
    fun getAllSquares(): List<Square>
    fun findById(uniqueId : String) : Optional<Square>
    fun createSquare(shape : Square) : CreateShapeResponse
}