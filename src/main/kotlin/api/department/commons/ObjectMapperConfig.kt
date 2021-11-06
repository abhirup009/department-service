package api.department.commons

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class ObjectMapperConfig {
    @Bean
    fun getObjectMapper(jackson2ObjectMapperBuilder: Jackson2ObjectMapperBuilder): ObjectMapper {
        val objectMapper = jackson2ObjectMapperBuilder
            .createXmlMapper(false)
            .build<ObjectMapper>()

        return objectMapper.apply {
            disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
        }
    }
}