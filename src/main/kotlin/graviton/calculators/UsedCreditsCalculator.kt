package graviton.calculators

import graviton.calculators.strategies.finder.StrategyFinder
import graviton.dal.core.UsageDao
import graviton.dal.factory.DaoFactory

object UsedCreditsCalculator {

    fun calculate(customerId: String): Int {
        val usageDao = DaoFactory.getDao<UsageDao>()
        val customersUsageInfoList = usageDao.queryByCustomerId(customerId)
        val strategy = StrategyFinder.getUsedCreditsCalculationStrategy(customerId)
        return strategy.calculate(customersUsageInfoList)
    }

}