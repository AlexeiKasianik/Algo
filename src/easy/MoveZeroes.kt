package easy

class MoveZeroes {

    // https://leetcode.com/problems/move-zeroes/description/


    // https://leetcode.com/problems/move-zeroes/submissions/1758242094/
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        for (n in nums) {
            if (n != 0) nums[i++] = n
        }
        while (i < nums.size) nums[i++] = 0

    }

    fun moveZeroes1(nums: IntArray): Unit {
        if (nums.size == 1) {
            return
        }

        var nonZeroIndex = 0

        for (i in 0..<nums.size) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i]
                nonZeroIndex++
            }
        }


        while (nonZeroIndex < nums.size) {
            nums[nonZeroIndex] = 0
            nonZeroIndex++
        }

    }

    fun test() {
        moveZeroes(intArrayOf(0, 1, 0, 3, 12)) // [1,3,12,0,0]
        moveZeroes(intArrayOf(0)) // [0]
        moveZeroes(intArrayOf(1,2)) // [1,2]
        moveZeroes(intArrayOf(1,0)) // [1,2]
    }

}