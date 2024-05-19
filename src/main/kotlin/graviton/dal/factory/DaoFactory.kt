package graviton.dal.factory

import graviton.dal.core.PurchaseDao
import graviton.dal.core.UsageDao
import graviton.dal.inmemorydao.InMemoryPurchaseDao
import graviton.dal.inmemorydao.InMemoryUsageDao

// based on the underlying database, the DAO will be different.
// This can be configured without making changes to the code which is using the Dao.
object DaoFactory {

    inline fun <reified T> getDao(): T {
        return when (val option = getUnderlyingDaoOption()) {
            "inMemory" -> getInMemoryDao()
            else -> throw IllegalArgumentException("Unsupported option: $option")
        }
    }

    // this needs to be modified based on the underlying the config store
    fun getUnderlyingDaoOption(): String {
        return "inMemory"
    }


    inline fun <reified T> getInMemoryDao(): T {
        return when {
            T::class == PurchaseDao::class -> InMemoryPurchaseDao as T
            T::class == UsageDao::class -> InMemoryUsageDao as T
            else -> throw IllegalArgumentException("Unsupported type for In Memory Dao: ${T::class.simpleName}")
        }
    }

}