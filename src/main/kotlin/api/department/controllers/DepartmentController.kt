package api.department.controllers

import api.department.commons.DepartmentEndpoints
import api.department.commons.StandardHeaders
import api.department.managers.DepartmentManager
import api.department.models.DepartmentDetails
import feign.Headers
import org.springframework.web.bind.annotation.*

@RestController
class DepartmentController(
    val departmentManager: DepartmentManager
) {
    @PostMapping(DepartmentEndpoints.Base)
    fun newDepartment(
        @RequestBody departmentRequest: DepartmentDetails,
        @RequestHeader(value = StandardHeaders.UserId) userId: String
    ): DepartmentDetails =
        departmentManager.newDepartment(departmentRequest = departmentRequest, userId = userId)

    @GetMapping(DepartmentEndpoints.Base)
    fun getDepartmentDetails(
        @RequestParam(value = DepartmentEndpoints.DepartmentNameParam, required = true)
        departmentName: String,
        @RequestHeader(value = StandardHeaders.UserId) userId: String
    ): DepartmentDetails =
        departmentManager.getDepartment(departmentName = departmentName, userId = userId)
}
