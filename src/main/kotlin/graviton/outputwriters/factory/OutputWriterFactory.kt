package graviton.outputwriters.factory

import graviton.outputwriters.impl.AvailableCreditsJsonReportWriter

object OutputWriterFactory {

    inline fun <reified T> getWriter(fileName: String): T {
        return when {
            fileName.endsWith(".json") -> getJsonWriter(fileName)
            fileName.endsWith(".xml") -> getXmlWriter(fileName)
            fileName.endsWith(".csv") -> getCsvWriter(fileName)
            else -> throw IllegalArgumentException("Unsupported file format for file: $fileName")
        }
    }

    inline fun <reified T> getJsonWriter(fileName: String): T {
        return when {
            T::class == AvailableCreditsJsonReportWriter::class -> AvailableCreditsJsonReportWriter as T
            else -> throw IllegalArgumentException("Unsupported type for JSON file: ${T::class.simpleName}")
        }
    }

    fun <T> getXmlWriter(fileName: String): T {
        // Stub method for writing XML files
        throw UnsupportedOperationException("XML file writing not implemented yet")
    }

    fun <T> getCsvWriter(fileName: String): T {
        // Stub method for writing CSV files
        throw UnsupportedOperationException("CSV file writing not implemented yet")
    }
}
