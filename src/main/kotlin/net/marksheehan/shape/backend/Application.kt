package net.marksheehan.shape.backend

import net.marksheehan.shape.backend.datamodel.Point
import net.marksheehan.shape.backend.datamodel.Square
import net.marksheehan.shape.backend.mongodb.ShapeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


//exclude = [MongoAutoConfiguration::class]
//CommandLineRunner
@SpringBootApplication
@EnableAutoConfiguration
class Application()  {
}
//@Autowired val repository: ShapeRepository

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
