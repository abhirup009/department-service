package api.department.models

/**
 * This should ideally be derived from a common package or jar that we are importing
 * into this project. For now I am keeping it this way to facilitate development.
 */
data class ProspectiveUser(
    val prospectiveUserId: String,
    val name: String
)