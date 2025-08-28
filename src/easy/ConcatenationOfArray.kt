package easy

class ConcatenationOfArray {

    // https://leetcode.com/problems/concatenation-of-array/

    // Время: O(n) — один проход по массиву.
    // Память: O(2n) = O(n) — для нового массива.
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)
        for (i in 0..nums.size - 1) {
            result[i] = nums[i]
            result[i + nums.size] = nums[i]
        }
        return result
    }

    fun test() {
        println(getConcatenation(intArrayOf(1,2,1)).joinToString()) // [1, 2, 1, 1, 2, 1]
        println(getConcatenation(intArrayOf(1,3,2,1)).joinToString()) // [1, 3, 2, 1, 1, 3, 2, 1]
    }
}