package domain

class Calculator {

    fun division(first: String, second: String): String {
        val totalOfDivision = first.toInt() / second.toInt()
        val remainder = first.toInt() % second.toInt()
        return "$totalOfDivision remainder $remainder"
    }

    fun multiplication(first: String, second: String): String {
        val totalOfMultiplication = first.toInt() * second.toInt()
        return totalOfMultiplication.toString()
    }

    fun subtraction(first: String, second: String): String {
        val totalOfSubtraction = first.toInt() - second.toInt()
        return totalOfSubtraction.toString()
    }

    fun addition(first: String, second: String): String {
        val totalOfAddition = first.toInt() + second.toInt()
        return totalOfAddition.toString()
    }
}