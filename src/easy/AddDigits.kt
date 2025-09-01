package easy

class AddDigits {

    // https://leetcode.com/problems/add-digits/description/

    fun addDigits(num: Int): Int {
        if (num == 0) return 0
        var value = num

        while (value >= 10) {
            var sum = 0
            while (value > 0) {
                sum += value % 10
                value /= 10
            }
            value = sum
        }
        return value
    }

    fun test() {
        println(addDigits(38))
        println(addDigits(0))
        println(addDigits(101))
    }

}