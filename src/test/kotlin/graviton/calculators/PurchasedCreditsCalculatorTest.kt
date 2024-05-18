package graviton.calculators

import graviton.calculators.strategies.core.PurchasedCreditsCalculationStrategy
import graviton.calculators.strategies.finder.StrategyFinder
import graviton.dal.core.PurchaseDao
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PurchasedCreditsCalculatorTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            mockkObject(StrategyFinder)
        }

        @AfterAll
        @JvmStatic
        fun tearDown() {
            unmockkAll()
        }
    }

    @Test
    fun `test calculate`() {
        val customerId = "customerId"
        val purchasedCredits = 100

        val mockPurchaseDao = mockk<PurchaseDao>()
        val mockPurchasedCreditsStrategy = mockk<PurchasedCreditsCalculationStrategy>()

        every { StrategyFinder.getPurchasedCreditsCalculationStrategy(customerId) } returns mockPurchasedCreditsStrategy
        every { mockPurchasedCreditsStrategy.calculate(any()) } returns purchasedCredits

        val purchasedCreditsCalculator = PurchasedCreditsCalculator
        val calculatedPurchasedCredits = purchasedCreditsCalculator.calculate(customerId)
        assertEquals(purchasedCredits, calculatedPurchasedCredits)
    }
}
