package api.department.utils

import api.department.models.DepartmentDetails
import recommender.jooq.tables.records.DeptDetailsRecord

fun DepartmentDetails.toRecord() =
    DeptDetailsRecord()
        .apply {
            this.name = this@toRecord.name
            this.userId = this@toRecord.userId
            this.address = this@toRecord.address
        }

fun DeptDetailsRecord.toDepartmentRequest() =
    DepartmentDetails(
        name = this.name,
        userId = this.userId,
        address = this.address
    )
