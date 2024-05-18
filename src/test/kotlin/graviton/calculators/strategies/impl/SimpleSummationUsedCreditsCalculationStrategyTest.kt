package graviton.calculators.strategies.impl

import graviton.config.inmemory.InMemoryServicePriceConfig
import graviton.exceptions.ServiceNotFoundException
import graviton.models.ServicePrice
import graviton.models.UsageInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class SimpleSummationUsedCreditsCalculationStrategyTest {

    @Test
    fun `test calculate with valid usageInfoList`() {
        val serviceName1 = "ServiceA"
        val serviceName2 = "ServiceB"
        val noOfCredits1 = 100
        val noOfCredits2 = 200
        val usageInfoList = listOf(
            UsageInfo("customerId1", serviceName1),
            UsageInfo("customerId2", serviceName2)
        )

        InMemoryServicePriceConfig.batchSave(
            listOf(
                ServicePrice(serviceName1, noOfCredits1),
                ServicePrice(serviceName2, noOfCredits2)
            )
        )

        val strategy = SimpleSummationUsedCreditsCalculationStrategy
        val totalUsedCredits = strategy.calculate(usageInfoList)
        assertEquals(noOfCredits1 + noOfCredits2, totalUsedCredits)
    }

    @Test
    fun `test calculate with invalid serviceName`() {
        val invalidServiceName = "InvalidService"
        val usageInfoList = listOf(
            UsageInfo("customerId", invalidServiceName)
        )

        val strategy = SimpleSummationUsedCreditsCalculationStrategy
        assertThrows(ServiceNotFoundException::class.java) {
            strategy.calculate(usageInfoList)
        }
    }
}
