import graviton.inputreaders.impl.UsageInfoJsonInputFileReader
import graviton.models.UsageInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UsageInfoJsonInputFileReaderTest {

    @Test
    fun `test readList UsageInfo`() {
        val expectedUsageInfoList = listOf(
            UsageInfo("C12345", "S1"),
            UsageInfo("C67890", "S2"),
            UsageInfo("C11223", "S3"),
            UsageInfo("C44556", "S1"),
            UsageInfo("C78901", "S2")
        )

        val usageInfoList = UsageInfoJsonInputFileReader.readList("usage_info.json")
        assertEquals(expectedUsageInfoList, usageInfoList)
    }
}
