package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Rectangle
import java.util.*

data class CreateShapeResponse(val success : Boolean, val message : String, val id : String?)

interface ShapeService {
    fun getAllSquares(): List<Rectangle>
    fun findById(uniqueId : String) : Optional<Rectangle>
    fun createSquare(shape : Rectangle) : CreateShapeResponse
}