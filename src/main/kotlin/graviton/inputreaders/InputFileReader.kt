package graviton.inputreaders

import graviton.inputreaders.impl.PricingInfoJsonInputFileReader
import graviton.inputreaders.impl.PurchaseInfoJsonInputFileReader
import graviton.inputreaders.impl.UsageInfoJsonInputFileReader
import graviton.models.PricingInfo
import graviton.models.PurchaseInfo
import graviton.models.UsageInfo
import org.example.graviton.inputreaders.factory.FileReaderFactory

object InputFileReader {

    fun read(
        pricingFileName: String,
        purchaseFileName: String,
        usageFileName: String
    ): Triple<PricingInfo, List<PurchaseInfo>, List<UsageInfo>> {

        val pricingInfoInputFileReader = FileReaderFactory.getReader<PricingInfoJsonInputFileReader>(pricingFileName)
        val pricingInfo = pricingInfoInputFileReader.read(pricingFileName)
//        println("pricingInfo = $pricingInfo")

        val purchaseInfoJsonInputFileReader = FileReaderFactory.getReader<PurchaseInfoJsonInputFileReader>(pricingFileName)
        val purchaseInfoList = purchaseInfoJsonInputFileReader.readList(purchaseFileName)
//        println("purchaseInfoList = $purchaseInfoList")

        val usageInfoJsonInputFileReader = FileReaderFactory.getReader<UsageInfoJsonInputFileReader>(pricingFileName)
        val usageInfoList = usageInfoJsonInputFileReader.readList(usageFileName)
//        println("usageInfoList = $usageInfoList")

        return Triple(pricingInfo, purchaseInfoList, usageInfoList)

    }

}