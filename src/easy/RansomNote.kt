package easy

class RansomNote {

    // https://leetcode.com/problems/ransom-note/
    // https://leetcode.com/explore/learn/card/the-leetcode-beginners-guide/692/challenge-problems/4427/

    // решение пройдёт простую проверку Но при сабмите задачи свалится.
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (magazine.length < ransomNote.length) return false
        var magazineBuffer = magazine
        outer@ for (i in 0..ransomNote.length - 1) {
            val testLetter = ransomNote[i]

            inner@ for (j in 0..magazineBuffer.length - 1) {
                if (testLetter == magazineBuffer[j]) {
                    magazineBuffer = magazineBuffer.removeRange(j, j + 1)
                    break@inner
                } else return false
            }
        }
        return true
    }

    // это уже пройдёт
    fun canConstructSlow(ransomNote: String, magazine: String): Boolean {
        if (magazine.length < ransomNote.length) return false
        var magazineBuffer = magazine

        for (i in 0 until ransomNote.length) {
            val need = ransomNote[i]
            var found = false

            for (j in 0 until magazineBuffer.length) {
                if (need == magazineBuffer[j]) {
                    magazineBuffer = magazineBuffer.removeRange(j, j + 1)
                    found = true
                    break
                }
            }
            if (!found) return false
        }
        return true
    }

    fun canConstructSlow2(ransomNote: String, magazine: String): Boolean {
        if (magazine.length < ransomNote.length) return false
        var buf = magazine
        for (c in ransomNote) {
            val idx = buf.indexOf(c)
            if (idx == -1) return false
            buf = buf.removeRange(idx, idx + 1)
        }
        return true
    }

    // time complexity O(nm)
    // space complexity O(m)
    fun canConstruct1(ransomNote: String, magazine: String): Boolean {
        var magazineBuffer = magazine
        for (i in 0..ransomNote.length - 1) {
            val r = ransomNote[i]
            val matchingIndex = magazineBuffer.indexOf(r)
            if (matchingIndex == -1) {
                return false
            }
            magazineBuffer = magazineBuffer.substring(0, matchingIndex) + magazineBuffer.substring(matchingIndex + 1)
        }
        return true
    }

    // time complexity O(m)
    // space complexity O(k)
    fun canConstruct2(ransomNote: String, magazine: String): Boolean {
        val magazineLetters = HashMap<Char, Int>()

        for(i in 0..magazine.length - 1) {
            val m = magazine[i]
            val currentCount = magazineLetters.getOrDefault(m, 0)
            magazineLetters.put(m, currentCount + 1)
        }

        for (i in 0..ransomNote.length - 1) {
            val r = ransomNote[i]

            val currentCount = magazineLetters.getOrDefault(r, 0)
            if (currentCount == 0) {
                return false
            }
            magazineLetters.put(r, currentCount - 1)
        }

        return true
    }


    // ИИ решение. Лень было разбирать.
    // Идея
    //	•	У нас только строчные английские буквы → 26 возможных символов.
    //	•	Делаем массив freq длины 26, где
    //freq[0] — сколько букв 'a', freq[1] — 'b', …, freq[25] — 'z'.
    //	•	Индекс для буквы считаем как c - 'a' (в Kotlin 'c' - 'a' == 2).
    //
    //Алгоритм
    //	1.	Если ransomNote длиннее magazine, ответ сразу false (не хватит букв).
    //	2.	Создаём freq = IntArray(26) (все нули).
    //	3.	Проходим по magazine и увеличиваем счётчики:
    //	•	для каждой буквы m делаем freq[m - 'a']++.
    //	4.	Проходим по ransomNote и “тратим” буквы:
    //	•	для каждой буквы r находим i = r - 'a'.
    //	•	если freq[i] == 0, значит такой буквы больше нет → false.
    //	•	иначе freq[i]-- (использовали одну).
    //	5.	Если всё прошли без возврата false, значит хватило всех букв → true.
    //
    //Пошаговый разбор на примере
    //
    //Пример 1
    //
    //ransomNote = "aa", magazine = "aab"
    //
    //Шаг 1–3: считаем magazine
    //	•	Старт: все freq[*] = 0.
    //	•	Считываем 'a' → freq[0] = 1
    //	•	Считываем 'a' → freq[0] = 2
    //	•	Считываем 'b' → freq[1] = 1
    //
    //Итого значимые: freq[0]=2, freq[1]=1.
    //
    //Шаг 4: “тратим” на ransomNote
    //	•	Берём 'a' → индекс 0. freq[0] было 2 → уменьшаем до 1.
    //	•	Берём 'a' → индекс 0. freq[0] было 1 → уменьшаем до 0.
    //
    //Не упёрлись в ноль раньше времени, значит true.
    //
    //Пример 2
    //
    //ransomNote = "aa", magazine = "ab"
    //
    //Счёт magazine: freq[0]=1, freq[1]=1.
    //
    //Тратим для ransomNote:
    //	•	Первая 'a': freq[0] 1 → 0.
    //	•	Вторая 'a': freq[0] уже 0 → не хватает → false.

    fun canConstruct3(ransomNote: String, magazine: String): Boolean {
        // Быстрая отсечка: букв точно меньше, чем нужно
        if (ransomNote.length > magazine.length) return false

        // Таблица частот для 26 букв 'a'..'z'
        val freq = IntArray(26) // все нули

        // 1) Считаем, сколько каких букв есть в magazine
        for (c in magazine) {
            freq[c - 'a']++
        }

        // 2) Пытаемся "потратить" эти буквы на ransomNote
        for (c in ransomNote) {
            val i = c - 'a'
            if (freq[i] == 0) return false // этой буквы больше нет
            freq[i]-- // используем одну штуку
        }

        // 3) Все буквы нашлись
        return true
    }


    fun test() {
        println(canConstruct("a", "b"))
        println(canConstruct("aa", "ab"))
        println(canConstruct("aa", "aab"))
    }

}