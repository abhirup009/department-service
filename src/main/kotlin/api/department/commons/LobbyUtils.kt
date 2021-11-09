package api.department.commons

import api.department.commons.clients.HttpLobbyClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.discovery.EurekaClient
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Lazy
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class LobbyUtils(
    private val departmentConfig: Environment,
    private val objectMapper: ObjectMapper
) {
    private val apiGatewayEndpoint = departmentConfig.getProperty("backend.external-endpoints.api-gateway")
    private val lobbyEndpointSuffix = departmentConfig.getProperty("backend.external-endpoints.default")

    private val lobbyEndpoint = "$apiGatewayEndpoint$lobbyEndpointSuffix"

    val lobbyClient: HttpLobbyClient = Feign.builder()
        .encoder(JacksonEncoder(objectMapper))
        .decoder(JacksonDecoder(objectMapper))
        .logLevel(Logger.Level.FULL)
        .logger(Logger.ErrorLogger())
        .target(HttpLobbyClient::class.java, lobbyEndpoint)

    fun getProspectiveUser(prospectiveUserId: String) =
        lobbyClient.getProspectiveUser(userId = prospectiveUserId)
}