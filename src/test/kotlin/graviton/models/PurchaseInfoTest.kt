package graviton.models

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

class PurchaseInfoTest {

    private val timestamp = Date()
    private val purchaseInfo = PurchaseInfo(
        customerId = "12345",
        packageName = "PremiumPackage",
        timestamp = timestamp
    )

    @Test
    fun getCustomerId() {
        assertEquals("12345", purchaseInfo.customerId)
    }

    @Test
    fun getPackageName() {
        assertEquals("PremiumPackage", purchaseInfo.packageName)
    }

    @Test
    fun getTimestamp() {
        assertEquals(timestamp, purchaseInfo.timestamp)
    }

    @Test
    operator fun component1() {
        assertEquals("12345", purchaseInfo.component1())
    }

    @Test
    operator fun component2() {
        assertEquals("PremiumPackage", purchaseInfo.component2())
    }

    @Test
    operator fun component3() {
        assertEquals(timestamp, purchaseInfo.component3())
    }
}
