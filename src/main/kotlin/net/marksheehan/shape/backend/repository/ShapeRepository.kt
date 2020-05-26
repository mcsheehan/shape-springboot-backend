package net.marksheehan.shape.backend.repository

import net.marksheehan.shape.backend.datamodel.Square
import org.springframework.data.mongodb.repository.MongoRepository

interface ShapeRepository : MongoRepository<Square, String> {

    fun findAllOrderByUniqueId() : List<Square>
}