package graviton.reports

import graviton.calculators.AvailableCreditsCalculator
import graviton.dal.core.PurchaseDao
import graviton.dal.factory.DaoFactory
import graviton.outputwriters.factory.OutputWriterFactory
import graviton.outputwriters.impl.AvailableCreditsJsonReportWriter
import graviton.reports.models.AvailableCredits
import graviton.reports.models.AvailableCreditsReport

private const val NUMBER_OF_CUSTOMERS = 1000

object AvailableCreditsReportGenerator {

    fun generate(availableCreditsReportFileName: String) {
        val customerIds = collectCustomerIds(NUMBER_OF_CUSTOMERS)
        val availableCredits = customerIds.map { getAvailableCredits(it) }.toList()
        val report = AvailableCreditsReport(availableCredits)
        val writer = OutputWriterFactory.getWriter<AvailableCreditsJsonReportWriter>(availableCreditsReportFileName)
        writer.write(availableCreditsReportFileName, report)
    }

    private fun getAvailableCredits(it: String): AvailableCredits {
        val availableCredits = AvailableCreditsCalculator.calculate(it)

        val comment = when {
            availableCredits > 0 -> "$it has $availableCredits credits to use our services."
            availableCredits == 0 -> "$it has no credits to use any of our services. Kindly renew subscriptions."
            availableCredits < 0 -> "$it has ver less credits - $availableCredits, some service usage would have impact. Kindly renew subscriptions."
            else -> "Invalid credits value" // Optional catch-all case
        }

        return AvailableCredits(it, availableCredits, comment)
    }

    private fun collectCustomerIds(n: Int): List<String> {
        val customerIds = mutableListOf<String>()
        val pageSize = 50
        var pageNumber = 1
        var hasMore = true
        val purchaseDao = DaoFactory.getDao<PurchaseDao>()

        while (hasMore && customerIds.size < n) {
            val paginatedResult = purchaseDao.queryAllCustomers(pageNumber, pageSize)
            customerIds.addAll(paginatedResult.items)
            hasMore = paginatedResult.hasMore
            pageNumber++
        }

        return customerIds
    }


}
