package api.department.managers

import api.department.commons.LobbyUtils
import feign.FeignException
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class SecurityManager(
    private val lobbyUtils: LobbyUtils
) {
    fun checkUserValidity(prospectiveUserId: String): Boolean =
        lobbyUtils.getProspectiveUser(prospectiveUserId = prospectiveUserId)
            .let {
                true
            }
}