package net.marksheehan.shape.backend.datamodel

import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id

enum class ShapeType {
    RECTANGLE,
    CIRCLE
}

open class Shape(var type: ShapeType) {

    @ApiModelProperty("This unique ID should be blank when creating new shapes")
    @Id
    var uniqueId: String? = null
//        public set
}
