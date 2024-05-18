import graviton.inputreaders.impl.PricingInfoJsonInputFileReader
import graviton.models.CreditsPrice
import graviton.models.PricingInfo
import graviton.models.ServicePrice
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PricingInfoJsonInputFileReaderTest {

    @Test
    fun `test read PricingInfo`() {
        val expectedPricingInfo = PricingInfo(
            listOf(
                ServicePrice("S1", 1),
                ServicePrice("S2", 2),
                ServicePrice("S3", 3)
            ),
            listOf(
                CreditsPrice("Basic Package", 100, 100.00, "USD"),
                CreditsPrice("Standard Package", 250, 225.00, "USD"),
                CreditsPrice("Premium Package", 500, 450.00, "USD")
            )
        )

        val pricingInfo = PricingInfoJsonInputFileReader.read("pricing_info.json")

        assertEquals(expectedPricingInfo, pricingInfo)
    }
}
