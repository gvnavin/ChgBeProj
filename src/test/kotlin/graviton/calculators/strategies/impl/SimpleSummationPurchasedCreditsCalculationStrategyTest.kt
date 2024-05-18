package graviton.calculators.strategies.impl

import graviton.config.inmemory.InMemoryCreditsPriceConfig
import graviton.exceptions.CreditsPricePackageNotFoundException
import graviton.inputreaders.impl.helpers.dateFormat
import graviton.models.CreditsPrice
import graviton.models.PurchaseInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class SimpleSummationPurchasedCreditsCalculationStrategyTest {

    @Test
    fun `test calculate with valid purchaseInfoList`() {
        val packageName1 = "PackageA"
        val packageName2 = "PackageB"
        val noOfCredits1 = 100
        val noOfCredits2 = 200
        val purchaseInfoList = listOf(
            PurchaseInfo("customerId1", packageName1, dateFormat.parse("2024-07-20T20:45:00Z")),
            PurchaseInfo("customerId2", packageName2, dateFormat.parse("2024-07-20T20:45:00Z"))
        )

        InMemoryCreditsPriceConfig.batchSave(
            listOf(
                CreditsPrice(packageName1, noOfCredits1, 0.0, ""),
                CreditsPrice(packageName2, noOfCredits2, 0.0, "")
            )
        )

        val strategy = SimpleSummationPurchasedCreditsCalculationStrategy
        val totalPurchasedCredits = strategy.calculate(purchaseInfoList)
        assertEquals(noOfCredits1 + noOfCredits2, totalPurchasedCredits)
    }

    @Test
    fun `test calculate with invalid packageName`() {
        val invalidPackageName = "InvalidPackage"
        val purchaseInfoList = listOf(
            PurchaseInfo("customerId", invalidPackageName, dateFormat.parse("2024-07-20T20:45:00Z")),
        )

        val strategy = SimpleSummationPurchasedCreditsCalculationStrategy
        assertThrows(CreditsPricePackageNotFoundException::class.java) {
            strategy.calculate(purchaseInfoList)
        }
    }
}
