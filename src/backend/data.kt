package backend

abstract class Data

enum class Type {
    INT, STRING, BOOLEAN, NONE, FUNCTION
}

object None:Data() {
    override fun toString() = "None"
}

object NullData: Data() {
    override fun toString(): String = "NULL"
}

class IntData(val value: Int) : Data() {
    override fun toString() = value.toString()
}

class StringData(val value: String) : Data() {
    override fun toString() = value
}

class BooleanData(val value: Boolean) : Data() {
    override fun toString() = value.toString()
}


// literals since getting expr error using just the data itself, likely because toString? not sure
class IntLiteral(val lexeme: String): Expr() {
    override fun eval(runtime: Runtime): Data = IntData(lexeme.toInt())
    override fun typeCheck(env:TypeEnvironment): Type = Type.INT
}


class StringLiteral(val lexeme: String) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val cleanedString = lexeme.trim('"')
        return StringData(cleanedString)
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        return Type.STRING
    }
}


class BooleanLiteral(val lexeme: String): Expr() {
    override fun eval(runtime: Runtime): Data = BooleanData(lexeme.toBoolean())
    override fun typeCheck(env: TypeEnvironment): Type = Type.BOOLEAN
}

// for func data
class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString()
    = params.joinToString(", ").let {
        "$name($it) { ... }"
    }
}


