package graviton.config.factory

import graviton.config.core.CreditsPriceConfig
import graviton.config.core.ServicePriceConfig
import graviton.config.inmemory.InMemoryCreditsPriceConfig
import graviton.config.inmemory.InMemoryServicePriceConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ConfigFactoryTest {

    @Test
    fun `test getConfig with supported type`() {
        val creditsPriceConfig: CreditsPriceConfig = ConfigFactory.getConfig()
        assertTrue(creditsPriceConfig is InMemoryCreditsPriceConfig)

        val servicePriceConfig: ServicePriceConfig = ConfigFactory.getConfig()
        assertTrue(servicePriceConfig is InMemoryServicePriceConfig)
    }

    @Test
    fun `test getConfig with unsupported type`() {
        assertThrows(IllegalArgumentException::class.java) {
            ConfigFactory.getConfig<String>()
        }
    }

    @Test
    fun `test getUnderlyingConfigStoreOption`() {
        assertEquals("inMemory", ConfigFactory.getUnderlyingConfigStoreOption())
    }

    @Test
    fun `test getInMemoryConfig with supported type`() {
        val creditsPriceConfig: CreditsPriceConfig = ConfigFactory.getInMemoryConfig()
        assertTrue(creditsPriceConfig is InMemoryCreditsPriceConfig)

        val servicePriceConfig: ServicePriceConfig = ConfigFactory.getInMemoryConfig()
        assertTrue(servicePriceConfig is InMemoryServicePriceConfig)
    }

    @Test
    fun `test getInMemoryConfig with unsupported type`() {
        assertThrows(IllegalArgumentException::class.java) {
            ConfigFactory.getInMemoryConfig<String>()
        }
    }
}
