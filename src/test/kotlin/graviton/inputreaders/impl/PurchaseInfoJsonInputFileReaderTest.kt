import graviton.inputreaders.impl.PurchaseInfoJsonInputFileReader
import graviton.inputreaders.impl.helpers.dateFormat
import graviton.models.PurchaseInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseInfoJsonInputFileReaderTest {

    @Test
    fun `test readList PurchaseInfo`() {
        val expectedPurchaseInfoList = listOf(
            PurchaseInfo("C12345", "Basic Package", dateFormat.parse("2024-05-18T14:30:00Z")),
            PurchaseInfo("C67890", "Standard Package", dateFormat.parse("2024-06-01T09:15:00Z")),
            PurchaseInfo("C11223", "Premium Package", dateFormat.parse("2024-07-20T20:45:00Z")),
            PurchaseInfo("C44556", "Basic Package", dateFormat.parse("2024-08-15T16:00:00Z")),
            PurchaseInfo("C78901", "Standard Package", dateFormat.parse("2024-09-10T12:00:00Z"))
        )

        val purchaseInfoList = PurchaseInfoJsonInputFileReader.readList("purchase_info.json")

        assertEquals(expectedPurchaseInfoList, purchaseInfoList)
    }
}
