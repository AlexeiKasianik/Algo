package easy

class LongestCommonPrefix {
    // https://leetcode.com/problems/longest-common-prefix/
    // худший случчай O(n*m) n - количество строк, m - длина строки
    fun longestCommonPrefix(strs: Array<String>): String {
        // Сразу стараемся обработать корнер кейсы
        if (strs.isEmpty()) return ""

        // Берём первую строку как начальный префикс
        var prefix = strs[0]

        // Проходим по всем остальным строкам
        for (i in 1 until strs.size) {
            val current = strs[i]

            // Укорачиваем префикс, пока текущая строка не начинается с него
            while (!current.startsWith(prefix)) {
                prefix = prefix.dropLast(1) // убираем последний символ
                if (prefix.isEmpty()) return "" // префикса нет
            }
        }
        return prefix
    }

    fun test() {
        val examples = listOf(
            arrayOf("flower", "flow", "flight"),
            arrayOf("dog", "racecar", "car"),
            arrayOf("interspecies", "interstellar", "interstate"),
            arrayOf("a"),
            arrayOf("ab", "a"),
            arrayOf("prefix", "prefixes", "preform")
        )

        for (example in examples) {
            val result = longestCommonPrefix(example)
            println("Input: ${example.joinToString(", ")}")
            println("Longest common prefix: \"$result\"")
            println("----")
        }
    }
}