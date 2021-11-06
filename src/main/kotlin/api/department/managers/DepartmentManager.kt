package api.department.managers

import api.department.data.DepartmentDao
import api.department.models.DepartmentDetails
import org.springframework.stereotype.Service

@Service
class DepartmentManager(
    private val departmentDao: DepartmentDao,
    private val securityManager: SecurityManager
) {
    fun newDepartment(departmentRequest: DepartmentDetails, userId: String): DepartmentDetails {
        securityManager.checkUserValidity(prospectiveUserId = userId)
        return departmentDao.newDepartment(departmentRequest = departmentRequest)
    }

    fun getDepartment(departmentName: String, userId: String): DepartmentDetails {
        securityManager.checkUserValidity(prospectiveUserId = userId)
        return departmentDao.getDepartmentDetails(departmentName = departmentName)
    }
}
