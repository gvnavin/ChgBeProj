package graviton.calculators

import graviton.calculators.strategies.finder.StrategyFinder
import graviton.dal.core.PurchaseDao
import graviton.dal.factory.DaoFactory

object PurchasedCreditsCalculator {

    fun calculate(customerId: String): Int {
        val purchaseDao = DaoFactory.getDao<PurchaseDao>()
        val customersPurchaseInfoList = purchaseDao.queryByCustomerId(customerId)
        val strategy = StrategyFinder.getPurchasedCreditsCalculationStrategy(customerId)
        return strategy.calculate(customersPurchaseInfoList)
    }

}