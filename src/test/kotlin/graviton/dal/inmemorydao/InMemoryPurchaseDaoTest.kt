package graviton.dal.inmemorydao

import graviton.models.PurchaseInfo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

class InMemoryPurchaseDaoTest {

    @Test
    fun testBatchSaveAndQueryByCustomerId() {
        val customerId1 = "12345"
        val customerId2 = "67890"

        val purchaseInfo1 = PurchaseInfo(customerId1, "BasicPackage", Date())
        val purchaseInfo2 = PurchaseInfo(customerId1, "PremiumPackage", Date())
        val purchaseInfo3 = PurchaseInfo(customerId2, "BasicPackage", Date())

        val purchaseList = listOf(purchaseInfo1, purchaseInfo2, purchaseInfo3)

        InMemoryPurchaseDao.batchSave(purchaseList)

        val retrievedPurchases1 = InMemoryPurchaseDao.queryByCustomerId(customerId1)
        val retrievedPurchases2 = InMemoryPurchaseDao.queryByCustomerId(customerId2)

        assertEquals(2, retrievedPurchases1.size)
        assertTrue(retrievedPurchases1.contains(purchaseInfo1))
        assertTrue(retrievedPurchases1.contains(purchaseInfo2))

        assertEquals(1, retrievedPurchases2.size)
        assertTrue(retrievedPurchases2.contains(purchaseInfo3))
    }

    @Test
    fun testQueryByNonExistingCustomerId() {
        val retrievedPurchases = InMemoryPurchaseDao.queryByCustomerId("nonExistingCustomerId")
        assertTrue(retrievedPurchases.isEmpty())
    }
}
