package graviton.calculators.strategies.finder

import graviton.calculators.strategies.core.AvailableCreditsCalculationStrategy
import graviton.calculators.strategies.core.PurchasedCreditsCalculationStrategy
import graviton.calculators.strategies.core.UsedCreditsCalculationStrategy
import graviton.calculators.strategies.impl.SimpleDifferenceAvailableCreditsCalculationStrategy
import graviton.calculators.strategies.impl.SimpleSummationPurchasedCreditsCalculationStrategy
import graviton.calculators.strategies.impl.SimpleSummationUsedCreditsCalculationStrategy

//Based on some rules. Rules can be specific to customer or offer or global config
object StrategyFinder {

    fun getPurchasedCreditsCalculationStrategy(customerId: String): PurchasedCreditsCalculationStrategy {
        return SimpleSummationPurchasedCreditsCalculationStrategy
    }

    fun getUsedCreditsCalculationStrategy(customerId: String): UsedCreditsCalculationStrategy {
        return SimpleSummationUsedCreditsCalculationStrategy
    }

    fun getAvailableCreditsCalculationStrategy(customerId: String): AvailableCreditsCalculationStrategy {
        return SimpleDifferenceAvailableCreditsCalculationStrategy
    }
}