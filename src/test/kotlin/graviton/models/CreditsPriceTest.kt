package graviton.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreditsPriceTest {

    private val creditsPrice = CreditsPrice(
        packageName = "BasicPackage",
        noOfCredits = 100,
        price = 29.99,
        denomination = "USD"
    )

    @Test
    fun getPackageName() {
        assertEquals("BasicPackage", creditsPrice.packageName)
    }

    @Test
    fun getNoOfCredits() {
        assertEquals(100, creditsPrice.noOfCredits)
    }

    @Test
    fun getPrice() {
        assertEquals(29.99, creditsPrice.price)
    }

    @Test
    fun getDenomination() {
        assertEquals("USD", creditsPrice.denomination)
    }

    @Test
    operator fun component1() {
        assertEquals("BasicPackage", creditsPrice.component1())
    }

    @Test
    operator fun component2() {
        assertEquals(100, creditsPrice.component2())
    }

    @Test
    operator fun component3() {
        assertEquals(29.99, creditsPrice.component3())
    }

    @Test
    operator fun component4() {
        assertEquals("USD", creditsPrice.component4())
    }
}
