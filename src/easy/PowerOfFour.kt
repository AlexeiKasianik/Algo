package easy

class PowerOfFour {

    // https://leetcode.com/problems/power-of-four/description/

    // простую проверку пройдёт. На сабмите упадёт ошибка
    // Time Limit Exceeded
    fun isPowerOfFour(n: Int): Boolean {

        if (n == 4 || n == 1) return true

        var testValue = 4
        var result = false
        while (testValue < n) {
            testValue *= 4
            if (testValue == n) result = true
            if (testValue > n) result = false
        }
        return result
    }

    fun isPowerOfFour1(n: Int): Boolean {
        if (n <= 0) return false
        var testValue = n
        while (testValue % 4 == 0) {
            testValue /= 4
        }
        return testValue == 1
    }

}
