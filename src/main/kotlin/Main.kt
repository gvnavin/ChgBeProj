import graviton.calculators.AvailableCreditsCalculator
import graviton.calculators.PurchasedCreditsCalculator
import graviton.calculators.UsedCreditsCalculator
import graviton.config.core.CreditsPriceConfig
import graviton.config.core.ServicePriceConfig
import graviton.config.factory.ConfigFactory
import graviton.dal.core.PurchaseDao
import graviton.dal.core.UsageDao
import graviton.dal.factory.DaoFactory
import graviton.inputreaders.InputFileReader
import graviton.models.CreditsPrice

fun main() {

    val (pricingInfo, purchaseInfoList, usageInfoList) = InputFileReader.read(
        "pricing_info.json",
        "purchase_info.json",
        "usage_info.json"
    )

    ConfigFactory.getConfig<CreditsPriceConfig>().batchSave(pricingInfo.credits)
    ConfigFactory.getConfig<ServicePriceConfig>().batchSave(pricingInfo.services)

    DaoFactory.getDao<PurchaseDao>().batchSave(purchaseInfoList)
    DaoFactory.getDao<UsageDao>().batchSave(usageInfoList)

    val purchasedCredits = PurchasedCreditsCalculator.calculate("C12345")
    println("purchasedCredits = ${purchasedCredits}")

    val usedCredits = UsedCreditsCalculator.calculate("C12345")
    println("usedCredits = ${usedCredits}")

    val availableCredits = AvailableCreditsCalculator.calculate("C12345")
    println("availableCredits = ${availableCredits}")

}