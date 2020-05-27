package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.datamodel.Shape
import net.marksheehan.shape.backend.datamodel.Rectangle
import net.marksheehan.shape.backend.service.CreateShapeResponse
import net.marksheehan.shape.backend.service.ShapeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.*
import java.util.concurrent.atomic.AtomicLong


@RestController
class ShapeController(@Autowired val shapeService: ShapeService) {

    val counter = AtomicLong()

    @GetMapping("/shapes")
    fun getShapes(): List<Shape> {
        return shapeService.getAllSquares()
    }

    @GetMapping("/shape/{shapeId}")
    fun getShapeById(@PathVariable shapeId: String): Optional<Rectangle> {
        return shapeService.findById(shapeId)
    }

    @PostMapping("/shape")
    fun createShape(@RequestBody shape: Rectangle): ResponseEntity<Any> {

        val createShapeResponse: CreateShapeResponse = shapeService.createSquare(shape)

        if (!createShapeResponse.success) {
            return ResponseEntity.badRequest().body(createShapeResponse.message)
        }

        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createShapeResponse.id)
                .toUri()

        return ResponseEntity.created(location).body(createShapeResponse.message)
    }

    @GetMapping("/")
    fun linkToDocumentation(): String {
        val documentationLocation: String = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/swagger-ui.html")
                .build()
                .toString()

        return "<HTML><body> " +
                "<a href=\"$documentationLocation\">" +
                "Rest Api Documentation</a></body></HTML>"
    }

}