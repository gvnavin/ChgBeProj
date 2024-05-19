package graviton.outputwriters.core

interface OutputFileWriter<T> {

    fun write(fileName: String, data: T): Unit = TODO()

    fun writeList(fileName: String, dataList: List<T>): Unit  = TODO()

}
