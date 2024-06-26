package graviton.config.inmemory

import graviton.config.core.CreditsPriceConfig
import graviton.exceptions.CreditsPricePackageNotFoundException
import graviton.models.CreditsPrice

object InMemoryCreditsPriceConfig : CreditsPriceConfig {

    private val indexByPackageName = HashMap<String, CreditsPrice>()

    override fun batchSave(creditsPriceList: List<CreditsPrice>) {
        indexByPackageName(creditsPriceList)
    }

    private fun indexByPackageName(creditsPriceList: List<CreditsPrice>) {
        for (creditsPrice in creditsPriceList) {
            indexByPackageName[creditsPrice.packageName] = creditsPrice
        }
    }

    override fun getByPackageName(packageName: String): CreditsPrice {
        return indexByPackageName[packageName] ?: throw CreditsPricePackageNotFoundException(packageName)
    }

}