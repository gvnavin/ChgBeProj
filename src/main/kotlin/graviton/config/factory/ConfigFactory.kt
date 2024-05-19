package graviton.config.factory

import graviton.config.core.CreditsPriceConfig
import graviton.config.core.ServicePriceConfig
import graviton.config.inmemory.InMemoryCreditsPriceConfig
import graviton.config.inmemory.InMemoryServicePriceConfig


// based on the underlying config system, this factory will return the correct config
// This can be configured without making changes to the using code
object ConfigFactory {

    inline fun <reified T> getConfig(): T {
        return when (val option = getUnderlyingConfigStoreOption()) {
            "inMemory" -> getInMemoryConfig()
            else -> throw IllegalArgumentException("Unsupported option: $option")
        }
    }

    // this needs to be modified based on the underlying the config store
    fun getUnderlyingConfigStoreOption(): String {
        return "inMemory"
    }


    inline fun <reified T> getInMemoryConfig(): T {
        return when {
            T::class == CreditsPriceConfig::class -> InMemoryCreditsPriceConfig as T
            T::class == ServicePriceConfig::class -> InMemoryServicePriceConfig as T
            else -> throw IllegalArgumentException("Unsupported type for In Memory Config: ${T::class.simpleName}")
        }
    }

}