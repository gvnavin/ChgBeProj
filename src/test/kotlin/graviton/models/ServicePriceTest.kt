package graviton.models

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ServicePriceTest {

    private val servicePrice = ServicePrice(
        serviceName = "ServiceA",
        noOfCredits = 10
    )

    @Test
    fun getServiceName() {
        assertEquals("ServiceA", servicePrice.serviceName)
    }

    @Test
    fun getNoOfCredits() {
        assertEquals(10, servicePrice.noOfCredits)
    }

    @Test
    operator fun component1() {
        assertEquals("ServiceA", servicePrice.component1())
    }

    @Test
    operator fun component2() {
        assertEquals(10, servicePrice.component2())
    }
}
