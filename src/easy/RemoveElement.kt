package easy

class RemoveElement {

    // https://leetcode.com/problems/remove-element/

    // решение не будет засчитано leetCode т.к. будет проверять массив nums,
    // который не изменился и не соответствует условиям задачи
    // другая часть задания выполнена
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val result = mutableListOf<Int>()
        for (i in 0..nums.size - 1) {
            if (nums[i] != `val`) {
                result.add(nums[i])
            }
        }
        return result.size
    }


    // time complexity O(n)
    // space complexity O(1)

    fun removeElement1(nums: IntArray, `val`: Int): Int {
        // позиция верного элемента (неравного входящему)
        var startPosition = 0
        for (i in 0..nums.size - 1) {
            if (nums[i] != `val`) {
                // ставим на позицию верного элемента тот, который нужен
                nums[startPosition] = nums[i]
                // переходим на следующую позицию для верного элемента
                ++startPosition
            }
        }
        // по итогу получаем количество верных элементов и массив изменён так, что сначала идут верные элменты
        // а что там дальше не имеет значения
        return startPosition
    }

    fun test() {
        println(removeElement1(intArrayOf(3, 2, 2, 3), 3)) // 2, nums = [2,2,_,_]
        println(removeElement1(intArrayOf(0,1,2,2,3,0,4,2), 2)) // 5, nums = [0,1,4,0,3,_,_,_]
    }

}