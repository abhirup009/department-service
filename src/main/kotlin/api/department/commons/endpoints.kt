package api.department.commons

object StandardHeaders {
    const val UserId = "X-User-Id"
}

object CommonEndpoints {
    private const val Root = "/platform"
    private const val Version = "/v1"
    const val Base = "${Version}${Root}"
}

object DepartmentEndpoints {
    const val Base = "${CommonEndpoints.Base}/department"

    const val DepartmentNameParam = "departmentName"
}
