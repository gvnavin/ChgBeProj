package graviton.config.inmemory

import graviton.models.ServicePrice
import graviton.config.core.ServicePriceConfig
import graviton.exceptions.ServiceNotFoundException

object InMemoryServicePriceConfig: ServicePriceConfig {

    private val indexByServiceName = HashMap<String, ServicePrice>()

    override fun batchSave(servicePriceList: List<ServicePrice>) {
        indexByServiceName(servicePriceList)
    }

    private fun indexByServiceName(servicePriceList: List<ServicePrice>) {
        for (servicePrice in servicePriceList) {
            indexByServiceName[servicePrice.serviceName] = servicePrice
        }
    }

    override fun getByServiceName(serviceName: String): ServicePrice {
        return indexByServiceName[serviceName] ?: throw ServiceNotFoundException(serviceName)
    }


}