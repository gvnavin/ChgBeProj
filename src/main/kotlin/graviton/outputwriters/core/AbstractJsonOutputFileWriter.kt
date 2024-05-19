package graviton.outputwriters.core

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import com.beust.klaxon.Parser.Companion.default
import java.io.File

abstract class AbstractJsonOutputFileWriter<T> : OutputFileWriter<T> {

    protected open fun getFile(fileName: String): File {
        val resource = object {}.javaClass.getResource("/$fileName")
        val file: File

        if (resource != null) {
            val jsonFilePath = resource.file
            file = File(jsonFilePath)
        } else {
            // Create a new file in the specified directory
            file = File(fileName)
            file.createNewFile()
        }
        return file
    }

    override fun write(fileName: String, data: T) {
        internalWrite(fileName, data as Any)
    }

    private fun internalWrite(fileName: String, data: Any) {
        val file = getFile(fileName)
        val jsonString = prettyPrint(data)
        file.writeText(jsonString)
    }

    private fun prettyPrint(dataList: Any): String {
        val klaxon = Klaxon()
        val sb = StringBuilder(klaxon.toJsonString(dataList))
        val jsonString = (default(  ).parse(sb) as JsonObject).toJsonString(true)
        return jsonString
    }
}
