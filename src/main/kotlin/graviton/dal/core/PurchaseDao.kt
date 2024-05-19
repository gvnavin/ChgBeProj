package graviton.dal.core

import graviton.dal.models.PaginatedResult
import graviton.models.PurchaseInfo

interface PurchaseDao : CrudDao<PurchaseInfo, String> {
    fun queryAllCustomers(pageNumber: Int, pageSize: Int): PaginatedResult<String>
    fun getNoOfCustomers(): Int
}