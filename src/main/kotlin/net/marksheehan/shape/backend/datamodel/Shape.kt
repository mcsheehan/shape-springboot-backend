package net.marksheehan.shape.backend.datamodel

import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

enum class ShapeType {
    SQUARE,
    CIRCLE
}

open class Shape(var type: ShapeType) {

    @ApiModelProperty("This unique ID should be blank when creating new shapes")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var uniqueId: String? = null
//        public set
}
