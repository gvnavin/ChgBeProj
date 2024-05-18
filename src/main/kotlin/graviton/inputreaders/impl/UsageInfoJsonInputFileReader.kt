package graviton.inputreaders.impl

import graviton.inputreaders.core.AbstractJsonInputFileReader
import graviton.models.UsageInfo
import java.io.File

object UsageInfoJsonInputFileReader : AbstractJsonInputFileReader<UsageInfo>() {

    override fun readList(fileName: String): List<UsageInfo> {
        val usageInfoList: List<UsageInfo> = convertList(fileName)
        return usageInfoList
    }

}
