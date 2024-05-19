package graviton.calculators.strategies.core

interface AvailableCreditsCalculationStrategy {
    fun calculate(purchasedCredits: Int, usedCredits: Int): Int
}