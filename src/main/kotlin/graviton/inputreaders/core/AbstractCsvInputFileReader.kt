package graviton.inputreaders.core

import graviton.inputreaders.core.InputFileReader

abstract class AbstractCsvInputFileReader<T> : InputFileReader<T> {

    override fun read(fileName: String): T {
        TODO("Not yet implemented")
    }

    override fun readList(fileName: String): List<T> {
        TODO("Not yet implemented")
    }
}