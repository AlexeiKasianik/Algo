package easy

class NumberOfStepsToReduceANumberToZero {
    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
    // https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/692/challenge-problems/4425/
    // там в конце пример с битовыми операциями, но не стал разбирать

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    fun numberOfSteps(num: Int): Int {
        if(num == 0) return 0
        var testNum = num
        var result = 0
        while (testNum != 0) {
            if(testNum % 2 == 0) {
                testNum = testNum / 2
            } else {
                testNum == --testNum
            }
            ++result
        }
        return result
    }


    fun test() {
        println(numberOfSteps(14))  // 6
        println(numberOfSteps(8))   // 4
        println(numberOfSteps(123)) // 12
        println(numberOfSteps(0))   // 0
    }
}