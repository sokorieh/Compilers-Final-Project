package backend

abstract class Expr {
    abstract fun eval(runtime: Runtime): Data
    abstract fun typeCheck(env: TypeEnvironment): Type 
}

enum class Operator {
    Add, Sub, Mul, Div
}

class Arithmetic(
    val op: Operator,
    val left: Expr,
    val right: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        
        typeCheck(runtime.typeEnvironment)
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        return performOperation(x, y)
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        val leftType = left.typeCheck(env)
        val rightType = right.typeCheck(env)
        when (op) {
            Operator.Add, Operator.Sub -> {
                if (leftType != Type.INT || rightType != Type.INT) {
                    throw Exception("Addition and subtraction operations are only supported for integers.")
                }
                return Type.INT
            }
            Operator.Mul -> {
                if (leftType == Type.INT && rightType == Type.INT) {
                    return Type.INT
                } else if (leftType == Type.STRING && rightType == Type.INT) {
                    return Type.STRING
                } else {
                    throw Exception("Multiplication only supported between integers or an integer and a string.")
                }
            }
            Operator.Div -> {
                if (leftType != Type.INT || rightType != Type.INT) {
                    throw Exception("Division operations are only supported for integers.")
                }
                return Type.INT
            }
            else -> throw Exception("Unsupported operator $op")
        }
    }


    private fun performOperation(x: Data, y: Data): Data {
        return when (op) {
            Operator.Add -> IntData((x as IntData).value + (y as IntData).value)
            Operator.Sub -> IntData((x as IntData).value - (y as IntData).value)
            Operator.Mul -> when {
                x is IntData && y is IntData -> IntData(x.value * y.value)
                x is StringData && y is IntData -> StringData(x.value.repeat(y.value))
                else -> throw Exception("Unsupported operand types for '*'.")
            }
            Operator.Div -> {
                if ((y as IntData).value == 0) throw Exception("Cannot divide by zero.")
                IntData((x as IntData).value / y.value)
            }
        }
    }
}



class Concat(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        // Directly cast and concatenate string values from both sides
        val leftStr = (left.eval(runtime) as StringData).value
        val rightStr = (right.eval(runtime) as StringData).value
        return StringData(leftStr + rightStr)
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        // Check the types of the left and right expressions
        val leftType = left.typeCheck(env)
        val rightType = right.typeCheck(env)

        // Verify that both types are STRING to proceed with concatenation
        if (leftType == Type.STRING && rightType == Type.STRING) {
            return Type.STRING
        }

        // Throw an exception if either type is not a string
        throw Exception("Concatenation requires string types for both operands.")
    }
}




class Invoke(val name: String, val args: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val func = runtime.symbolTable[name] as? FuncData ?: throw Exception("$name does not exist or is not a function")
        if (func.params.size != args.size) {
            throw Exception("$name expects ${func.params.size} arguments but received ${args.size}")
        }
        val r = runtime.subscope(func.params.zip(args.map { it.eval(runtime) }).toMap())
        return func.body.eval(r)
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        val funcType = env.getType(name) ?: throw Exception("Function $name is not defined.")
        if (funcType != Type.FUNCTION) {
            throw Exception("$name must be a function.")
        }
        args.forEach { it.typeCheck(env) }
        return Type.NONE  // Assuming functions do not return a value by default
    }
}


class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data = FuncData(name, params, body).also {
        runtime.symbolTable[name] = it
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        val newEnv = env.subscope()
        params.forEach { param -> newEnv.declare(param, Type.INT) }  // Assuming all parameters are integers
        body.typeCheck(newEnv)
        env.declare(name, Type.FUNCTION)
        return Type.NONE
    }
}


class Deref(val name: String) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val data = runtime.symbolTable[name] ?: throw Exception("$name is not assigned.")
        return data
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        return env.getType(name) ?: throw Exception("$name is not defined.")
    }
}


class Block(val exprList: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        var result: Data = NullData
        exprList.forEach { result = it.eval(runtime) }
        return result
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        var lastType: Type = Type.NONE
        exprList.forEach { lastType = it.typeCheck(env) }
        return lastType  // Return the type of the last expression in the block
    }
}


class Print(val expression: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val result = expression.eval(runtime)
        println(result)  // Assuming toString is overridden in Data subclasses
        return NullData
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        expression.typeCheck(env)
        return Type.NONE
    }
}



class Assign(val symbol: String, val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data = expr.eval(runtime).apply {
        runtime.symbolTable[symbol] = this
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        val exprType = expr.typeCheck(env)
        env.declare(symbol, exprType)
        return exprType
    }
}


class ForLoop(
    val loopVar: String,
    val startExpr: Expr,
    val endExpr: Expr,
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val start = startExpr.eval(runtime)
        val end = endExpr.eval(runtime)

        if (start !is IntData || end !is IntData) {
            throw Exception("For-loop ranges must be integers.")
        }

        runtime.symbolTable[loopVar] = start

        var flag = true
        var result: Data = NullData
        while (flag) {
            result = body.eval(runtime)

            val currentVal = (runtime.symbolTable[loopVar] as IntData).value + 1
            runtime.symbolTable[loopVar] = IntData(currentVal)

            flag = currentVal <= end.value
        }

        return result
    }

    override fun typeCheck(env: TypeEnvironment): Type {
        if (startExpr.typeCheck(env) != Type.INT || endExpr.typeCheck(env) != Type.INT) {
            throw Exception("For-loop ranges must be integers.")
        }
        env.declare(loopVar, Type.INT)
        body.typeCheck(env)
        env.remove(loopVar)
        return Type.NONE
    }
}



