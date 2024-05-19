package graviton.calculators.strategies.impl

import graviton.calculators.strategies.core.AvailableCreditsCalculationStrategy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimpleDifferenceAvailableCreditsCalculationStrategyTest {

    @Test
    fun `test calculate`() {
        val strategy: AvailableCreditsCalculationStrategy = SimpleDifferenceAvailableCreditsCalculationStrategy

        val purchasedCredits = 100
        val usedCredits = 50
        val expectedAvailableCredits = 50

        val availableCredits = strategy.calculate(purchasedCredits, usedCredits)
        assertEquals(expectedAvailableCredits, availableCredits)
    }
}
