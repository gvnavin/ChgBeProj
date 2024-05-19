package graviton.inputreaders.core

interface InputFileReader<T> {

    fun read(fileName: String): T = TODO()

    fun readList(fileName: String): List<T> = TODO()

}