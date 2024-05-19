package graviton.dal.inmemorydao

import graviton.dal.core.UsageDao
import graviton.models.UsageInfo

object InMemoryUsageDao : UsageDao {

    private val indexByCustomerId = HashMap<String, ArrayList<UsageInfo>>()

    override fun batchSave(entities: List<UsageInfo>) {
        indexByCustomerId(entities)
    }

    private fun indexByCustomerId(usageInfoList: List<UsageInfo>) {
        for (usageInfo in usageInfoList) {
            val localUsageInfoList = indexByCustomerId.getOrDefault(usageInfo.customerId, ArrayList())
            localUsageInfoList.add(usageInfo)
            indexByCustomerId[usageInfo.customerId] = localUsageInfoList
        }
    }

    override fun queryByCustomerId(customerId: String): ArrayList<UsageInfo> {
        return indexByCustomerId.getOrDefault(customerId, ArrayList())
    }
}