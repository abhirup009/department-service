package api.department.data

import api.department.models.DepartmentDetails

interface DepartmentDao {
    fun newDepartment(departmentRequest: DepartmentDetails): DepartmentDetails

    fun getDepartmentDetails(departmentName: String): DepartmentDetails
}
