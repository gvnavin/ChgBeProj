package graviton.calculators

import graviton.calculators.strategies.core.PurchasedCreditsCalculationStrategy
import graviton.calculators.strategies.core.UsedCreditsCalculationStrategy
import graviton.calculators.strategies.finder.StrategyFinder
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class AvailableCreditsCalculatorTest {

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
        val usedCredits = 50
        val expectedAvailableCredits = 50

        val mockPurchasedCreditsStrategy = mockk<PurchasedCreditsCalculationStrategy>()
        val mockUsedCreditsStrategy = mockk<UsedCreditsCalculationStrategy>()

        every { StrategyFinder.getPurchasedCreditsCalculationStrategy(customerId) } returns mockPurchasedCreditsStrategy
        every { StrategyFinder.getUsedCreditsCalculationStrategy(customerId) } returns mockUsedCreditsStrategy
        every { mockPurchasedCreditsStrategy.calculate(any()) } returns purchasedCredits
        every { mockUsedCreditsStrategy.calculate(any()) } returns usedCredits

        val availableCredits = AvailableCreditsCalculator.calculate(customerId)
        assertEquals(expectedAvailableCredits, availableCredits)
    }
}
