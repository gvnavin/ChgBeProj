package graviton.config.inmemory

import graviton.models.CreditsPrice
import graviton.exceptions.CreditsPricePackageNotFoundException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class InMemoryCreditsPriceConfigTest {

    @Test
    fun `test batchSave and getByPackageName`() {
        val creditsPriceList = listOf(
            CreditsPrice("PackageA", 100, 10.0, "USD"),
            CreditsPrice("PackageB", 200, 20.0, "USD")
        )
        InMemoryCreditsPriceConfig.batchSave(creditsPriceList)

        val creditsPriceA = InMemoryCreditsPriceConfig.getByPackageName("PackageA")
        assertEquals(creditsPriceList[0], creditsPriceA)

        val creditsPriceB = InMemoryCreditsPriceConfig.getByPackageName("PackageB")
        assertEquals(creditsPriceList[1], creditsPriceB)
    }

    @Test
    fun `test getByPackageName with non-existing package name`() {
        assertThrows(CreditsPricePackageNotFoundException::class.java) {
            InMemoryCreditsPriceConfig.getByPackageName("NonExistingPackage")
        }
    }
}
