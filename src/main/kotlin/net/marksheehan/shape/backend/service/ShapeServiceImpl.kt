package net.marksheehan.shape.backend.service

import net.marksheehan.shape.backend.datamodel.Square
import net.marksheehan.shape.backend.repository.ShapeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
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

        val b= shapeRepository.findAllSquares()

        val results = shapeRepository.isSquareIntersectingAnotherSquare(shape.topLeft.x,
                shape.topLeft.y,
                shape.bottomRight.x,
                shape.bottomRight.y)


//        val query = Query()
//
//        query.addCriteria(Criteria.where("leftPoint.x").lt(0).gt(20))
//        query.addCriteria(Criteria.where("leftPoint.x").lt(0).gt(50))
//
//        val mongoOps: MongoOperations = MongoTemplate(Mongo(), "database")
//
//        mongoOps.insert<Any>(Person("Joe", 34))
//
//        QueryBuilder.start()
//
//        query.addCriteria("\$and", andQuery)

        result.uniqueId?.let {
            return CreateShapeResponse(true, "Creation success, with id ${result.uniqueId}", it)
        }

        return CreateShapeResponse(false, "", null)
    }

}