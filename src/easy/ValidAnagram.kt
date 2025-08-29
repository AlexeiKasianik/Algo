package easy

class ValidAnagram {

    // https://leetcode.com/problems/valid-anagram/

    // решение похоже на RansomNote???
    // очень медленное
    // O(n³) по времени
    // O(n²) по памяти
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        var value = s

        outer@ for (i in 0..t.length - 1) {
            val char = t[i]

            inner@ for (j in 0..value.length - 1) {
                if(char == value[j]) {
                    value = value.removeRange(j, j + 1)
                    break@inner
                }
            }
        }
        return value.isEmpty()
    }

    // очевидно не это решение ожидается
    // по времени: O(n log n) (из-за сортировки),
    // по памяти: O(n).
    fun isAnagram1(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.toCharArray().sorted() == t.toCharArray().sorted()
    }

    // лучше всего решать таким подходом

    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val count = IntArray(26)

        // пояснение
        // В Kotlin (и во многих языках) Char на самом деле хранится как числовой код (Unicode).
        // Например:
        //	•	'a' → код 97
        //	•	'b' → код 98
        //	•	'c' → код 99

        // мы берём код буквы s[i] и вычитаем код 'a'.
        // Это сдвигает диапазон кодов так, что 'a' превращается в 0, 'b' в 1, 'c' в 2, …, 'z' в 25.
        // То есть буквы напрямую становятся индексами массива длиной 26.
        // val ch = 'c'
        // val index = ch - 'a'   // 'c'(99) - 'a'(97) = 2
        // Значит, для буквы 'c' мы берём ячейку номер 2 в массиве.

        // итого мы берём каждую букву из обоих массивов, отнимаем код буквы 'a' и получаем порядок в массиве
        // далее в этой ячейке увеличиваем значение если это первый массив, и отнимаем если второй массив
        // т.е. если пройдясь по всем буквам если в первой строке буква a встречалась 5 раз, а во втором 4,
        // то мы получим в первом элементе массива значение 1 (- если было наоборот 4 и 5 раз)
        for (i in s.indices) {
            count[s[i] - 'a']++   // увеличиваем счётчик буквы из s
            count[t[i] - 'a']--   // уменьшаем счётчик буквы из t
        }

        return count.all { it == 0 }
    }




    fun test() {
        print(isAnagram("anagram", "nagaram"))
        print(isAnagram("rat", "car"))
    }
}
