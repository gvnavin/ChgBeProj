package graviton.dal.inmemorydao

import graviton.models.UsageInfo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class InMemoryUsageDaoTest {

    @Test
    fun testBatchSaveAndQueryByCustomerId() {
        val customerId1 = "12345"
        val customerId2 = "67890"

        val usageInfo1 = UsageInfo(customerId1, "ServiceA")
        val usageInfo2 = UsageInfo(customerId1, "ServiceB")
        val usageInfo3 = UsageInfo(customerId2, "ServiceA")

        val usageList = listOf(usageInfo1, usageInfo2, usageInfo3)

        InMemoryUsageDao.batchSave(usageList)

        val retrievedUsages1 = InMemoryUsageDao.queryByCustomerId(customerId1)
        val retrievedUsages2 = InMemoryUsageDao.queryByCustomerId(customerId2)

        assertEquals(2, retrievedUsages1.size)
        assertTrue(retrievedUsages1.contains(usageInfo1))
        assertTrue(retrievedUsages1.contains(usageInfo2))

        assertEquals(1, retrievedUsages2.size)
        assertTrue(retrievedUsages2.contains(usageInfo3))
    }

    @Test
    fun testQueryByNonExistingCustomerId() {
        val retrievedUsages = InMemoryUsageDao.queryByCustomerId("nonExistingCustomerId")
        assertTrue(retrievedUsages.isEmpty())
    }
}
