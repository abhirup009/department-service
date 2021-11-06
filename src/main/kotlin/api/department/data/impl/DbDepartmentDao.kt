package api.department.data.impl

import api.department.data.DepartmentDao
import api.department.models.DepartmentDetails
import api.department.utils.toDepartmentRequest
import api.department.utils.toRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import recommender.jooq.Tables

@Repository
class DbDepartmentDao(
    private val dslContext: DSLContext
): DepartmentDao {
    override fun newDepartment(departmentRequest: DepartmentDetails): DepartmentDetails {
        return dslContext.insertInto(Tables.DEPT_DETAILS)
            .set(departmentRequest.toRecord())
            .returning()
            .fetchOne()
            .toDepartmentRequest()
    }

    override fun getDepartmentDetails(departmentName: String): DepartmentDetails {
        return dslContext.selectFrom(Tables.DEPT_DETAILS)
            .where(Tables.DEPT_DETAILS.NAME.eq(departmentName))
            .fetchOne()
            .toDepartmentRequest()
    }
}
