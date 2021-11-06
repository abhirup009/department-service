package api.department

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient


@SpringBootApplication(exclude = [R2dbcAutoConfiguration::class])
@EnableEurekaClient
class DepartmentApplication

fun main(args: Array<String>) {
	runApplication<DepartmentApplication>(*args)
}
