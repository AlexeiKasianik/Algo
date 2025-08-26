package easy

class RunningSumOf1dArray {
    // https://leetcode.com/problems/running-sum-of-1d-array/
    // Time complexity:
    // O(N) because we visit each element once.
    // Space complexity:
    // O(1) extra (besides the result array).
    fun runningSum(nums: IntArray): IntArray {
        // сразу убираем кейс с пустым массивом
        if (nums.isEmpty()) return intArrayOf()

        // Сразу создаём массив такого же размера
        val test = IntArray(nums.size)
        // сетаем туда первое значение такое же т.к. оно всегда будет совпадать
        test[0] = nums[0]
        // начинаем цикл с элемента в позиции 1 (второй по счёту)
        // И складываем его с элементом с предыдущей позиции
        for (i in 1..< nums.size) {
            test[i] = nums[i] + nums[i - 1]
        }
        return test
    }

    // то же самое, но чуть меньше букв
    /*fun runningSum(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            res[i] = sum
        }
        return res
    }*/

    // ещё меньше кода
    /*fun runningSum(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
    }*/

    fun test() {
        println(runningSum(intArrayOf()).toList())  // []
        println(runningSum(intArrayOf(1, 2, 3, 4)).toList())  // [1, 3, 6, 10]
        println(runningSum(intArrayOf(1, 1, 1, 1, 1)).toList())  // [1, 2, 3, 4, 5]
        println(runningSum(intArrayOf(3, 1, 2, 10, 1)).toList()) // [3, 4, 6, 16, 17]
    }
}