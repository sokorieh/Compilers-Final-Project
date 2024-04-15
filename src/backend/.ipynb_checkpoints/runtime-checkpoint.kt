package backend

class Runtime() {
    val symbolTable: MutableMap<String, Data> = mutableMapOf()
    val typeEnvironment: TypeEnvironment = TypeEnvironment()  // Include a TypeEnvironment instance

    fun subscope(bindings: Map<String, Data>): Runtime {
        val parentSymbolTable = this.symbolTable
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(bindings)
            typeEnvironment.typeTable.putAll(this@Runtime.typeEnvironment.typeTable)  // Ensure the new scope shares the same type environment
        }
    }

    override fun toString(): String =
        symbolTable.map { 
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
}


// Class for the static type checking
class TypeEnvironment() {
    val typeTable: MutableMap<String, Type> = mutableMapOf()

    fun declare(name: String, type: Type) {
        typeTable[name] = type
    }

    fun getType(name: String): Type? = typeTable[name]

    fun remove(name: String) {
        typeTable.remove(name)
    }
    
    // Create a new subscope that inherits the current type mappings
    fun subscope(): TypeEnvironment {
        val newEnv = TypeEnvironment()
        newEnv.typeTable.putAll(this.typeTable) // Copy all current mappings to the new environment
        return newEnv
    }
}

