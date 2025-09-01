package easy

class JewelsAndStones {

    // https://leetcode.com/problems/jewels-and-stones/

    fun numJewelsInStones(jewels: String, stones: String): Int {
        var result = 0
        for (i in jewels) {
            for (j in stones) {
                if (j == i) ++result
            }
        }
        return result
    }

    // ии-шка выдала такой ответ.
    // он медленнее
    fun numJewelsInStones1(jewels: String, stones: String): Int {
        val jewelSet = jewels.toSet()
        var count = 0
        for (stone in stones) {
            if (stone in jewelSet) {
                count++
            }
        }
        return count
    }

    fun test() {
        println(numJewelsInStones("aaB", "aAAbbbb"))
        println(numJewelsInStones("z", "ZZ"))
    }
}