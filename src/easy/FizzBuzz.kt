package easy

class FizzBuzz {

    // https://leetcode.com/problems/fizz-buzz/description/

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun fizzBuzz(n: Int): List<String> {
        val list = ArrayList<String>()
        for (i in 1..n) {
            if (i % 15 == 0) list.add("FizzBuzz")
            else if (i % 3 == 0) list.add("Fizz")
            else if (i % 5 == 0) list.add("Buzz")
            else list.add(i.toString())
        }
        return list
    }

    // Лучше через when
    fun fizzBuzz1(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 1..n) {
            when {
                i % 15 == 0 -> result.add("FizzBuzz")
                i % 3 == 0 -> result.add("Fizz")
                i % 5 == 0 -> result.add("Buzz")
                else -> result.add(i.toString())
            }
        }
        return result
    }

    fun fizzBuzz2(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1 ..n) {
            val divisibleBy3 = i % 3 == 0
            val divisibleBy5 = i % 5 == 0
            if (divisibleBy3 && divisibleBy5) result.add("FizzBuzz")
            else if (divisibleBy3) result.add("Fizz")
            else if (divisibleBy5) result.add("Buzz")
            else result.add(i.toString())
        }

        return result
    }

    // https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/692/challenge-problems/4424/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun fizzBuzz3(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1 ..n) {
            val divisibleBy3 = i % 3 == 0
            val divisibleBy5 = i % 5 == 0
            var currStr = ""

            if(divisibleBy3) {
                currStr += "Fizz"
            }
            if(divisibleBy5) {
                currStr += "Buzz"
            }
            if (currStr.isEmpty()) {
                currStr += i.toString()
            }
            result.add(currStr)
        }
        return result
    }

    fun test() {
        println(fizzBuzz3(3))   // [1, 2, Fizz]
        println(fizzBuzz3(5))   // [1, 2, Fizz, 4, Buzz]
        println(fizzBuzz3(15))  // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
    }

}