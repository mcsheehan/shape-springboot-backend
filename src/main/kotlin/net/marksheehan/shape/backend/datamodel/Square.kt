package net.marksheehan.shape.backend.datamodel

import io.swagger.annotations.ApiModel
import org.springframework.data.mongodb.core.mapping.Document
import io.swagger.annotations.ApiModelProperty
import javax.persistence.Entity
import javax.persistence.Table


@Document(collection = "square")
@ApiModel(description = "Class representing a square shape.")
@Entity
@Table(name = "square")
class Square(
        @ApiModelProperty("The top left most point")
        val topLeft: Point,
        val bottomRight: Point) : Shape(ShapeType.SQUARE) {

    override fun toString(): String {
        return "$uniqueId $type:  $topLeft, $bottomRight"
    }
}