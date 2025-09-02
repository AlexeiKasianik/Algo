package easy

class DecompressRunLengthEncodedList {

    // https://leetcode.com/problems/decompress-run-length-encoded-list/description/

    fun decompressRLElist(nums: IntArray): IntArray {
        val intArray = mutableListOf<Int>()
        for (i in 0..nums.size -2 step 2) {
            val value1 = nums[i]
            val value2 = nums[i + 1]
            for (j in 0..value1 - 1) {
                intArray.add(value2)
            }
        }
        return intArray.toIntArray()
    }

    fun test() {
        println(decompressRLElist(intArrayOf(1,2,3,4)).joinToString()) // [2,4,4,4]
        println(decompressRLElist(intArrayOf(1,1,2,3)).joinToString()) // [1,3,3]
    }

}