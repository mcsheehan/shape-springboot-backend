package net.marksheehan.shape.backend.datamodel

import io.swagger.annotations.ApiModel
import org.springframework.data.mongodb.core.mapping.Document
import io.swagger.annotations.ApiModelProperty


@Document(collection = "square")
@ApiModel(description = "Class representing a square shape.")
class Rectangle(@ApiModelProperty("The top left most point") val topLeft: Point,
                @ApiModelProperty("The bottom right most point") val bottomRight: Point) :
        Shape(ShapeType.RECTANGLE) {

    override fun toString(): String {
        return "$uniqueId $type:  $topLeft, $bottomRight"
    }
}