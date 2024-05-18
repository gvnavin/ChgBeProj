package graviton.calculators.strategies.impl

import graviton.calculators.strategies.core.UsedCreditsCalculationStrategy
import graviton.config.core.ServicePriceConfig
import graviton.config.factory.ConfigFactory
import graviton.models.UsageInfo

object SimpleSummationUsedCreditsCalculationStrategy : UsedCreditsCalculationStrategy {
    override fun calculate(usageInfoList: List<UsageInfo>): Int {
        return usageInfoList.sumOf { usageInfo ->
            val servicePriceConfig = ConfigFactory.getConfig<ServicePriceConfig>()
            val creditsPrice = servicePriceConfig.getByServiceName(usageInfo.serviceName)
            creditsPrice.noOfCredits
        }
    }
}