package graviton.calculators.strategies.core

import graviton.models.UsageInfo

interface UsedCreditsCalculationStrategy {
    fun calculate(usageInfoList: List<UsageInfo>) : Int
}