package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Square
import net.marksheehan.shape.backend.mongodb.ShapeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShapeServiceImpl(@Autowired val shapeRepository: ShapeRepository) : ShapeService {

    override fun getAllSquares(): List<Square> {
        return shapeRepository.findAll()
    }

    override fun findById(uniqueId: String): Optional<Square> {
        return shapeRepository.findById(uniqueId)
    }

    override fun createSquare(shape: Square)  : CreateShapeResponse{
        val result = shapeRepository.save(shape)

        result.uniqueId?.let {
            return CreateShapeResponse(true, "Creation success, with id ${result.uniqueId}", it)
        }

        return CreateShapeResponse(false, "", null)

    }

}