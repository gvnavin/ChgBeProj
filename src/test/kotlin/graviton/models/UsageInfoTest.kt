package graviton.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UsageInfoTest {

    private val usageInfo = UsageInfo(
        customerId = "12345",
        serviceName = "ServiceA"
    )

    @Test
    fun getCustomerId() {
        assertEquals("12345", usageInfo.customerId)
    }

    @Test
    fun getServiceName() {
        assertEquals("ServiceA", usageInfo.serviceName)
    }

    @Test
    operator fun component1() {
        assertEquals("12345", usageInfo.component1())
    }

    @Test
    operator fun component2() {
        assertEquals("ServiceA", usageInfo.component2())
    }
}
