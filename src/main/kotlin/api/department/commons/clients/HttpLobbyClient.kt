package api.department.commons.clients

import api.department.models.ProspectiveUser
import feign.Param
import feign.RequestLine

interface HttpLobbyClient {
    @RequestLine("GET /lobby?userId={userId}")
    fun getProspectiveUser(
        @Param(value = "userId") userId: String
    ): ProspectiveUser
}