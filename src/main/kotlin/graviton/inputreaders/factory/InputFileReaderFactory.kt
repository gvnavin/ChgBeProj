package graviton.inputreaders.factory

import graviton.inputreaders.impl.PricingInfoJsonInputFileReader
import graviton.inputreaders.impl.PurchaseInfoJsonInputFileReader
import graviton.inputreaders.impl.UsageInfoJsonInputFileReader

object FileReaderFactory {

    inline fun <reified T> getReader(fileName: String): T {
        return when {
            fileName.endsWith(".json") -> getJsonReader(fileName)
            fileName.endsWith(".xml") -> getXmlReader(fileName)
            fileName.endsWith(".csv") -> getCsvReader(fileName)
            else -> throw IllegalArgumentException("Unsupported file format for file: $fileName")
        }
    }

    inline fun <reified T> getJsonReader(fileName: String): T {
        return when {
            T::class == PricingInfoJsonInputFileReader::class -> PricingInfoJsonInputFileReader as T
            T::class == PurchaseInfoJsonInputFileReader::class -> PurchaseInfoJsonInputFileReader as T
            T::class == UsageInfoJsonInputFileReader::class -> UsageInfoJsonInputFileReader as T
            else -> throw IllegalArgumentException("Unsupported type for JSON file: ${T::class.simpleName}")
        }
    }

    fun <T> getXmlReader(fileName: String): T {
        // Stub method for reading XML files
        throw UnsupportedOperationException("XML file reading not implemented yet")
    }

    fun <T> getCsvReader(fileName: String): T {
        // Stub method for reading CSV files
        throw UnsupportedOperationException("CSV file reading not implemented yet")
    }
}
