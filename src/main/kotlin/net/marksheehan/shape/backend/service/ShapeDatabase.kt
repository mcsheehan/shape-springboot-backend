package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Shape
import org.springframework.stereotype.Service

@Service
class ShapeDatabase : IShapeDatabase {

    override fun addShapeToDb(shape: Shape): ShapeDatabaseCode {
        TODO("Not yet implemented")
    }

    override fun retrieveAllStoredShapes(): List<Shape> {
        TODO("Not yet implemented")
    }
}