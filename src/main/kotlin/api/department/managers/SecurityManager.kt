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
        try {
            lobbyUtils.getProspectiveUser(prospectiveUserId = prospectiveUserId)
                .let {
                    true
                }
        } catch (e: Exception) {
            throw SecurityException("Invalid userId: $prospectiveUserId passed in header.")
        }
}