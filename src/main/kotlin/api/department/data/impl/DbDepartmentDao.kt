package api.department.data.impl

import api.department.controllers.DepartmentController
import api.department.data.DepartmentDao
import api.department.models.DepartmentDetails
import api.department.utils.toDepartmentRequest
import api.department.utils.toRecord
import org.jooq.DSLContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import recommender.jooq.Tables

@Repository
class DbDepartmentDao(
    private val dslContext: DSLContext
): DepartmentDao {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(DbDepartmentDao::class.java)
    }

    override fun newDepartment(departmentRequest: DepartmentDetails): DepartmentDetails {
        logger.info("Adding new department: $departmentRequest to db.")
        return dslContext.insertInto(Tables.DEPT_DETAILS)
            .set(departmentRequest.toRecord())
            .returning()
            .fetchOne()
            .toDepartmentRequest()
    }

    override fun getDepartmentDetails(departmentName: String): DepartmentDetails {
        logger.info("Getting department details from db.")
        return dslContext.selectFrom(Tables.DEPT_DETAILS)
            .where(Tables.DEPT_DETAILS.NAME.eq(departmentName))
            .fetchOne()
            .toDepartmentRequest()
    }
}
