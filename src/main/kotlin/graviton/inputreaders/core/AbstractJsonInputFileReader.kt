package graviton.inputreaders.core

import com.beust.klaxon.Klaxon
import graviton.inputreaders.impl.helpers.dateConverter
import java.io.File

abstract class AbstractJsonInputFileReader<T> : InputFileReader<T> {

    protected open fun getFile(fileName: String): File {
        val jsonFilePath = object {}.javaClass.getResource("/$fileName")!!.file
        return File(jsonFilePath)
    }

    protected inline fun <reified T> convertList(fileName: String): List<T> {
        val klaxon = Klaxon().converter(dateConverter)
        val file = getFile(fileName)
        return klaxon.parseArray<T>(file)!!
    }

    protected inline fun <reified T> convert(fileName: String): T {
        val klaxon = Klaxon().converter(dateConverter)
        val file = getFile(fileName)
        return klaxon.parse<T>(file)!!
    }

}