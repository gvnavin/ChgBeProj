package graviton.dal.factory

import graviton.dal.core.PurchaseDao
import graviton.dal.core.UsageDao
import graviton.dal.inmemorydao.InMemoryPurchaseDao
import graviton.dal.inmemorydao.InMemoryUsageDao
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DaoFactoryTest {

    @Test
    fun `test getDao with supported type`() {
        val purchaseDao: PurchaseDao = DaoFactory.getDao()
        assertTrue(purchaseDao is InMemoryPurchaseDao)

        val usageDao: UsageDao = DaoFactory.getDao()
        assertTrue(usageDao is InMemoryUsageDao)
    }

    @Test
    fun `test getDao with unsupported type`() {
        assertThrows(IllegalArgumentException::class.java) {
            DaoFactory.getDao<String>()
        }
    }

    @Test
    fun `test getUnderlyingDaoOption`() {
        assertEquals("inMemory", DaoFactory.getUnderlyingDaoOption())
    }

    @Test
    fun `test getInMemoryDao with supported type`() {
        val purchaseDao: PurchaseDao = DaoFactory.getInMemoryDao()
        assertTrue(purchaseDao is InMemoryPurchaseDao)

        val usageDao: UsageDao = DaoFactory.getInMemoryDao()
        assertTrue(usageDao is InMemoryUsageDao)
    }

    @Test
    fun `test getInMemoryDao with unsupported type`() {
        assertThrows(IllegalArgumentException::class.java) {
            DaoFactory.getInMemoryDao<String>()
        }
    }
}
