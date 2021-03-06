package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Rectangle
import java.util.*

data class CreateShapeResponse(val success : Boolean, val message : String, val id : String?)

interface ShapeService {
    fun getAllRectangles(): List<Rectangle>
    fun findById(uniqueId : String) : Optional<Rectangle>
    fun createRectangle(shape : Rectangle) : CreateShapeResponse
}