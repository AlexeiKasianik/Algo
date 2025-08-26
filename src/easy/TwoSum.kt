package easy

class TwoSum {
    // https://leetcode.com/problems/two-sum/description/
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in nums.indices) {
            for(j in i + 1 until nums.size) {
                if(nums[j] + nums[i] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw RuntimeException("Solution not found")
    }

    fun test() {
        println(twoSum(nums = intArrayOf(2,7,11,15), target = 9).contentToString())
        println(twoSum(nums = intArrayOf(3,2,4), target = 6).contentToString())
        println(twoSum(nums = intArrayOf(3,3), target = 6).contentToString())
    }
}