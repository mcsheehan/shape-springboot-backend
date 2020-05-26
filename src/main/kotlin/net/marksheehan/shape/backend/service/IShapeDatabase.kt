package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Shape

enum class ShapeDatabaseCode {
    SUCCESS,
    FAILURE
}

interface IShapeDatabase {
    fun addShapeToDb(shape : Shape) : ShapeDatabaseCode
    fun retrieveAllStoredShapes() : List<Shape>
}
