package net.marksheehan.shape.backend

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
