package graviton.calculators.strategies.impl

import graviton.calculators.strategies.core.AvailableCreditsCalculationStrategy

object SimpleDifferenceAvailableCreditsCalculationStrategy: AvailableCreditsCalculationStrategy {
    override fun calculate(purchasedCredits: Int, usedCredits: Int) : Int {
        return purchasedCredits - usedCredits
    }
}