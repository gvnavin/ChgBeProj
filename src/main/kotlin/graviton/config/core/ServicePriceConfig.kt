package graviton.config.core

import graviton.models.ServicePrice

interface ServicePriceConfig: ConfigCrudDao<ServicePrice, String> {
    fun getByServiceName(serviceName: String): ServicePrice
}