package graviton.inputreaders.core

interface InputFileReader<T> {

    fun read(fileName: String): T

    fun readList(fileName: String): List<T>

}