package net.marksheehan.shape.backend.repository

import net.marksheehan.shape.backend.datamodel.Rectangle
import org.springframework.data.mongodb.repository.MongoRepository

interface ShapeRepository : MongoRepository<Rectangle, String> {

    fun findAllOrderByUniqueId() : List<Rectangle>
}