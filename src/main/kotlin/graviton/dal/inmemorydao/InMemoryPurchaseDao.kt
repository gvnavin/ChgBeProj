package graviton.dal.inmemorydao

import graviton.dal.core.PurchaseDao
import graviton.dal.models.PaginatedResult
import graviton.models.PurchaseInfo

object InMemoryPurchaseDao : PurchaseDao {

    private val indexByCustomerId = HashMap<String, ArrayList<PurchaseInfo>>()

    override fun batchSave(entities: List<PurchaseInfo>) {
        indexByCustomerId(entities)
    }

    private fun indexByCustomerId(purchaseInfoList: List<PurchaseInfo>) {
        for (purchaseInfo in purchaseInfoList) {
            val localPurchaseInfoList = indexByCustomerId.getOrDefault(purchaseInfo.customerId, ArrayList())
            localPurchaseInfoList.add(purchaseInfo)
            indexByCustomerId[purchaseInfo.customerId] = localPurchaseInfoList
        }
    }

    override fun queryByCustomerId(customerId: String): ArrayList<PurchaseInfo> {
        return indexByCustomerId.getOrDefault(customerId, ArrayList())
    }

    override fun queryAllCustomers(pageNumber: Int, pageSize: Int): PaginatedResult<String> {
        val allCustomers = indexByCustomerId.keys.toList()
        val fromIndex = (pageNumber - 1) * pageSize
        val toIndex = minOf(fromIndex + pageSize, allCustomers.size)

        if (fromIndex >= allCustomers.size || fromIndex < 0) {
            return PaginatedResult(emptySet(), false)
        }

        val paginatedCustomers = allCustomers.subList(fromIndex, toIndex).toSet()
        val hasMore = toIndex < allCustomers.size

        return PaginatedResult(paginatedCustomers, hasMore)
    }

    override fun getNoOfCustomers(): Int {
        return indexByCustomerId.size
    }

}