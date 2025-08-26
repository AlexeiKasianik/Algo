package easy

class PalindromeNumber {
    // https://leetcode.com/problems/palindrome-number/
    // time O(n) memory O(n)
    fun isPalindrome(x: Int): Boolean {
        // you can use this solution
        // if(x < 0) return false
        val s = x.toString()
        val sb = StringBuilder()
        for(i in s.length - 1 downTo 0) {
            sb.append(s[i])
        }
        return sb.toString() == s
    }

    fun isPalindromeSecond(x: Int): Boolean {
        // отрицательные и числа оканчивающиеся на 0 (кроме 0) — не палиндромы
        if (x < 0 || (x % 10 == 0 && x != 0)) return false

        var num = x
        var reversedHalf = 0

        while (num > reversedHalf) {
            val digit = num % 10
            reversedHalf = reversedHalf * 10 + digit
            num /= 10
        }

        // либо равны полностью (чётная длина), либо без середины (нечётная длина)
        return num == reversedHalf || num == reversedHalf / 10
    }

    fun test() {
        println(isPalindrome(121))
        println(isPalindrome(-121))
        println(isPalindrome(10))
        println(isPalindrome(101))
    }

    fun testSecondSolution() {
        println(isPalindromeSecond(121))
        println(isPalindromeSecond(-121))
        println(isPalindromeSecond(10))
        println(isPalindromeSecond(101))
    }
}