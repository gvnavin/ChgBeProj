package graviton.inputreaders.impl

import graviton.inputreaders.core.AbstractJsonInputFileReader
import graviton.models.PricingInfo

object PricingInfoJsonInputFileReader : AbstractJsonInputFileReader<PricingInfo>() {

    override fun read(fileName: String): PricingInfo {
        val pricingInfo: PricingInfo = convert(fileName)
        return pricingInfo
    }

}
