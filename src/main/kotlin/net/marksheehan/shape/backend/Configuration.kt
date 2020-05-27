package net.marksheehan.shape.backend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.marksheehan.shape.backend"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo {
        return ApiInfo(
                "Shape API",
                "A rest api receiving and validating rectangle shapes to ensure there is minimal overlap",
                "version 1.0",
                "TERMS OF SERVICE URL",
                Contact("Mark Sheehan", "www.marksheehan.net", "mark.sheehan.uk@gmail.com"),
                "MIT license",
                "https://opensource.org/licenses/MIT",
                Collections.emptyList()
        )
    }
}