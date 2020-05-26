package net.marksheehan.shape.backend.repository

import net.marksheehan.shape.backend.datamodel.Square
import org.springframework.data.mongodb.core.query.MongoRegexCreator
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.awt.print.Book
import java.util.*


interface ShapeRepository : MongoRepository<Square, String> {

    fun findAllOrderByUniqueId() : List<Square>

//    @Query("{topLeft} : {\$gt: ?0}")
//    fun findAllSquares() : List<Square>

    @Query("{ type : { \$eq : \"SQUARE\" } }, \$and : {}")
    fun findAllSquares() : List<Square>

//    @Query("{ topLeft.x : {}")
//    fun findAllSquare() : List<Square>{
//    }
//{ "topLeft.x" : { $eq : 0.0 } $and "topLeft.y" : { $eq : 51.0 } }
    @Query("{'\$or' : [{'topLeft.x' : {\$lt : ?0}}, {'topLeft.y' : {\$lt : ?1}}]}")
    fun findAllSquaresInRegion(pop: Double, area: Double): List<Square?>?

    @Query("{\"topLeft.x\" : {\$gt: ?0}, " +
            "\"topLeft.y\" : {\$gt: ?1}, " +
            "\"bottomRight.x\" : {\$gt : ?2}, " +
            "\"bottomRight.y\" : {\$lt : ?3}}")
    fun isSquareIntersectingAnotherSquare(x1 : Double, y1 : Double, x2 : Double, y2 : Double) : List<Square>

    fun buildQuery(){
        this.q
    }
//    @Query(value = "{writer : ?0}", collation = "{ 'locale' : '?1' }")
//    fun findBooksByWriter(writer: String?, collation: String?): Stream<Book?>?
}