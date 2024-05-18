package graviton.calculators

import graviton.calculators.strategies.finder.StrategyFinder

object AvailableCreditsCalculator {

    fun calculate(customerId: String): Int {
        val purchasedCredits = PurchasedCreditsCalculator.calculate(customerId)
        val usedCredits = UsedCreditsCalculator.calculate(customerId)
        val strategy = StrategyFinder.getAvailableCreditsCalculationStrategy(customerId)
        return strategy.calculate(purchasedCredits, usedCredits)
    }

}