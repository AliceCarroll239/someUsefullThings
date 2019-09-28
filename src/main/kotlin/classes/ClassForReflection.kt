package classes

class ClassForReflection {
    val stringParam: String = "string"
    val stringParam2: String = "string"
    val intParam: Int = 123
    val boolParam: Boolean = true
    val customObject: customClass = customClass()
}

data class customClass(
    val name: String = "Name",
    val id: Int = 1
)