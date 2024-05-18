package graviton.config.core

import graviton.models.CreditsPrice

interface CreditsPriceConfig : ConfigCrudDao<CreditsPrice, String> {
    fun getByPackageName(packageName: String): CreditsPrice
}
