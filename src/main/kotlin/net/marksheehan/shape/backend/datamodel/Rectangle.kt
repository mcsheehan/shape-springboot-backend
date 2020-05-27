package net.marksheehan.shape.backend.datamodel

import io.swagger.annotations.ApiModel
import org.springframework.data.mongodb.core.mapping.Document
import io.swagger.annotations.ApiModelProperty


@Document(collection = "rectangle")
@ApiModel(description = "Class representing a rectangle shape.")
class Rectangle(@ApiModelProperty("The top left most point") val topLeft: Point,
                @ApiModelProperty("The bottom right most point") val bottomRight: Point) :
        Shape(ShapeType.RECTANGLE) {

    override fun toString(): String {
        return "$uniqueId $type:  $topLeft, $bottomRight"
    }
}