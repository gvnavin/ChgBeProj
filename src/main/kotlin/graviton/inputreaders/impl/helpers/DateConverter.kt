package graviton.inputreaders.impl.helpers

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue
import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

val dateConverter = object : Converter {
    override fun canConvert(cls: Class<*>) = cls == Date::class.java

    override fun fromJson(jv: JsonValue) = dateFormat.parse(jv.string)

    override fun toJson(value: Any): String {
        val date = value as Date
        return "\"${dateFormat.format(date)}\""
    }
}