package graviton.dal.inmemorydao

import graviton.models.PurchaseInfo
import graviton.dal.core.PurchaseDao

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
}