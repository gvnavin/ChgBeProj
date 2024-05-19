package graviton.calculators.strategies.core

import graviton.models.PurchaseInfo

interface PurchasedCreditsCalculationStrategy {
    fun calculate(purchaseInfoList: List<PurchaseInfo>): Int
}