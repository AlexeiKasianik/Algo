package easy

class SubtractTheProductAndSumOfDigitsOfAnInteger {

    // https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/


    // Время: O(log n)
    // Память: O(1)
    fun subtractProductAndSum(n: Int): Int {
        if (n == 0) return 0
        var value = n
        var result = 0

        while (value >= 10) {
            var sum = 0
            var multi = 1
            while (value > 0) {
                val reminder = value % 10
                sum += reminder
                multi *= reminder
                value /= 10
            }
           result = multi - sum
        }
        return result
    }

    // то же самое только менее громоздское
    fun subtractProductAndSum1(n: Int): Int {
        var value = n
        var sum = 0
        var product = 1

        while (value > 0) {
            val digit = value % 10
            sum += digit
            product *= digit
            value /= 10
        }

        return product - sum
    }

    fun test() {
        println(subtractProductAndSum(234))
        println(subtractProductAndSum(4421))
    }

}