package graviton.dal.models

data class PaginatedResult<T>(
    val items: Set<T>,
    val hasMore: Boolean
)