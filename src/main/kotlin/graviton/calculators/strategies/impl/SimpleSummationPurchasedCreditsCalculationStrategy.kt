package graviton.calculators.strategies.impl

import graviton.models.PurchaseInfo
import graviton.calculators.strategies.core.PurchasedCreditsCalculationStrategy
import graviton.config.core.CreditsPriceConfig
import graviton.config.factory.ConfigFactory

object SimpleSummationPurchasedCreditsCalculationStrategy : PurchasedCreditsCalculationStrategy {
    override fun calculate(purchaseInfoList: List<PurchaseInfo>): Int {
        return purchaseInfoList.sumOf { purchaseInfo ->
            val creditsPriceConfig = ConfigFactory.getConfig<CreditsPriceConfig>()
            val creditsPrice = creditsPriceConfig.getByPackageName(purchaseInfo.packageName)
            creditsPrice.noOfCredits
        }
    }
}