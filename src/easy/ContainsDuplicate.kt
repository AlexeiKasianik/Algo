package easy

class ContainsDuplicate {

    // https://leetcode.com/problems/contains-duplicate/description/

    // Время: O(n) в среднем (каждая проверка/вставка в HashMap — O(1))
    // Память: O(n) (под хранение элементов)
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashMap = HashMap<Int, Int>()
        var result = false

        nums.forEach {
            val hashMapKeyValue = hashMap.getOrDefault(it, 0)
            if (hashMapKeyValue > 0) {
                result = true
                return@forEach
            }
            hashMap[it] = hashMapKeyValue + 1
        }
        return result
    }

    // Время: O(n) в среднем (каждая проверка/вставка в HashMap — O(1))
    // Память: O(n) (под хранение элементов)
    fun containsDuplicate1(nums: IntArray): Boolean {
        val hashMap = HashMap<Int, Int>()
        nums.forEach {
            if(hashMap[it] != null) return true
            hashMap[it] = it
        }
        return false
    }

    // Время: O(n)
    // Память: O(n) (Set хранит все элементы)
    fun containsDuplicate2(nums: IntArray): Boolean {
        val seen = HashSet<Int>()
        for (num in nums) {
            if (!seen.add(num)) return true
        }
        return false
    }


    fun test() {
        println(containsDuplicate(intArrayOf(1,2,3,1)))
        println(containsDuplicate(intArrayOf(1,2,3,4)))
        println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
    }

}