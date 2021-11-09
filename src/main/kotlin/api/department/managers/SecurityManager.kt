package api.department.managers

import api.department.commons.LobbyUtils
import api.department.controllers.DepartmentController
import feign.FeignException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.SecurityManager

@Service
class SecurityManager(
    private val lobbyUtils: LobbyUtils
) {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(SecurityManager::class.java)
    }

    fun checkUserValidity(prospectiveUserId: String): Boolean =
        try {
            logger.info("Checking validity for User: $$prospectiveUserId")
            lobbyUtils.getProspectiveUser(prospectiveUserId = prospectiveUserId)
                .let {
                    true
                }
        } catch (e: Exception) {
            throw SecurityException("Invalid userId: $prospectiveUserId passed in header.")
        }
}