package easy

class MajorityElement {

    // https://leetcode.com/problems/majority-element/description/

    // не самое быстрое решение
    // Сложность: O(n) по времени, O(n) по памяти.
    fun majorityElement(nums: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEach {
            var value = hashMap.getOrDefault(it, 0)
            hashMap.put(it, ++value)
            if (value > nums.size / 2) return it

        }
        return -1
    }

    // Сложность: O(n) времени и O(1) памяти
    fun majorityElement1(nums: IntArray): Int {
        var count = 0
        var candidate = 0

        nums.forEach {
            if (count == 0) {
                candidate = it
            }
            count += if (it == candidate) 1 else -1
        }
        return candidate
    }

    fun test() {
        println(majorityElement(intArrayOf(2, 3, 4, 2, 2, 1)))
        println(majorityElement(intArrayOf(3, 2, 3)))
        println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }
}