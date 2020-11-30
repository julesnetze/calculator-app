package domain

class Calculator {

    fun addition(first: String?, second: String?): String {
        return if (first is String && second is String) {
            val totalOfAddition = first.toInt() + second.toInt()
            totalOfAddition.toString()
        } else {
            return "invalid"
        }
    }

    fun subtraction(first: String?, second: String?): String {
        return if (first is String && second is String) {
            val totalOfSubtraction = first.toInt() - second.toInt()
            totalOfSubtraction.toString()
        } else {
            return "invalid"
        }
    }

    fun multiplication(first: String?, second: String?): String {
        return if (first is String && second is String) {
            val totalOfMultiplication = first.toInt() * second.toInt()
            totalOfMultiplication.toString()
        } else {
            return "invalid"
        }
    }

    fun division(first: String?, second: String?): String {
        return if (first is String && second is String) {
            val totalOfDivision = first.toInt() / second.toInt()
            val remainder = first.toInt() % second.toInt()
            "$totalOfDivision remainder $remainder"
        } else {
            return "invalid"
        }
    }
}