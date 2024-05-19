package graviton.config.inmemory

import graviton.exceptions.ServiceNotFoundException
import graviton.models.ServicePrice
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class InMemoryServicePriceConfigTest {

    @Test
    fun `test batchSave and getByServiceName`() {
        val servicePriceList = listOf(
            ServicePrice("ServiceA", 10),
            ServicePrice("ServiceB", 20)
        )
        InMemoryServicePriceConfig.batchSave(servicePriceList)

        val servicePriceA = InMemoryServicePriceConfig.getByServiceName("ServiceA")
        assertEquals(servicePriceList[0], servicePriceA)

        val servicePriceB = InMemoryServicePriceConfig.getByServiceName("ServiceB")
        assertEquals(servicePriceList[1], servicePriceB)
    }

    @Test
    fun `test getByServiceName with non-existing service name`() {
        assertThrows(ServiceNotFoundException::class.java) {
            InMemoryServicePriceConfig.getByServiceName("NonExistingService")
        }
    }
}
