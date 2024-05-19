package graviton.dal.core

interface CrudDao<T, ID> {
    fun batchSave(entities: List<T>)
    fun queryByCustomerId(customerId: String): ArrayList<T>

    //for future use cases, implement when needed
    fun create(entity: T): T = TODO()
    fun read(id: ID): T = TODO()
    fun update(entity: T): T = TODO()
    fun delete(id: ID): Void = TODO()

}