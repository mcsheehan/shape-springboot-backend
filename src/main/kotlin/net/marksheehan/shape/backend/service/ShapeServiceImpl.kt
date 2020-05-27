package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Rectangle
import net.marksheehan.shape.backend.repository.ShapeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShapeServiceImpl(@Autowired val shapeRepository: ShapeRepository) : ShapeService {

    override fun getAllRectangles(): List<Rectangle> {
        return shapeRepository.findAll()
    }

    override fun findById(uniqueId: String): Optional<Rectangle> {
        return shapeRepository.findById(uniqueId)
    }

    override fun createRectangle(shape: Rectangle)  : CreateShapeResponse{
        val result = shapeRepository.save(shape)

        result.uniqueId?.let {
            return CreateShapeResponse(true, "Creation success, with id ${result.uniqueId}", it)
        }

        return CreateShapeResponse(false, "", null)

    }

}