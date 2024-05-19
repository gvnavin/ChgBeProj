package graviton.calculators

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

class UsedCreditsCalculatorTest {

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
        val usedCredits = 50

        val mockUsedCreditsStrategy = mockk<UsedCreditsCalculationStrategy>()

        every { StrategyFinder.getUsedCreditsCalculationStrategy(customerId) } returns mockUsedCreditsStrategy
        every { mockUsedCreditsStrategy.calculate(any()) } returns usedCredits

        val usedCreditsCalculator = UsedCreditsCalculator
        val calculatedUsedCredits = usedCreditsCalculator.calculate(customerId)
        assertEquals(usedCredits, calculatedUsedCredits)
    }
}
