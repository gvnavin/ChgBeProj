package graviton.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PricingInfoTest {

    private val servicePrice1 = ServicePrice(serviceName = "ServiceA", noOfCredits = 1)
    private val servicePrice2 = ServicePrice(serviceName = "ServiceB", noOfCredits = 2)
    private val creditsPrice1 =
        CreditsPrice(packageName = "BasicPackage", noOfCredits = 100, price = 29.99, denomination = "USD")
    private val creditsPrice2 =
        CreditsPrice(packageName = "PremiumPackage", noOfCredits = 200, price = 49.99, denomination = "USD")

    private val pricingInfo = PricingInfo(
        services = listOf(servicePrice1, servicePrice2),
        credits = listOf(creditsPrice1, creditsPrice2)
    )

    @Test
    fun getServices() {
        val services = pricingInfo.services
        assertEquals(2, services.size)
        assertEquals(servicePrice1, services[0])
        assertEquals(servicePrice2, services[1])
    }

    @Test
    fun getCredits() {
        val credits = pricingInfo.credits
        assertEquals(2, credits.size)
        assertEquals(creditsPrice1, credits[0])
        assertEquals(creditsPrice2, credits[1])
    }

    @Test
    operator fun component1() {
        val services = pricingInfo.component1()
        assertEquals(2, services.size)
        assertEquals(servicePrice1, services[0])
        assertEquals(servicePrice2, services[1])
    }

    @Test
    operator fun component2() {
        val credits = pricingInfo.component2()
        assertEquals(2, credits.size)
        assertEquals(creditsPrice1, credits[0])
        assertEquals(creditsPrice2, credits[1])
    }
}
