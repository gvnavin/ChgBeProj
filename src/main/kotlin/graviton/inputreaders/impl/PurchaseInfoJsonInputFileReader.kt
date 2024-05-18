package graviton.inputreaders.impl

import graviton.inputreaders.core.AbstractJsonInputFileReader
import graviton.models.PurchaseInfo

object PurchaseInfoJsonInputFileReader : AbstractJsonInputFileReader<PurchaseInfo>() {

    override fun readList(fileName: String): List<PurchaseInfo> {
        val purchaseInfoList: List<PurchaseInfo> = convertList(fileName)
        return purchaseInfoList
    }

}
