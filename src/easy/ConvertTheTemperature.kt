package easy

class ConvertTheTemperature {

    // https://leetcode.com/problems/convert-the-temperature/description/

    fun convertTemperature(celsius: Double): DoubleArray {
        val array = DoubleArray(2)
        array[0] = celsius + 273.15
        array[1] = celsius * 1.80 + 32.00
        return array
    }

    fun convertTemperature1(celsius: Double): DoubleArray {
        val kelvin = celsius + 273.15
        val fahrenheit = celsius * 1.80 + 32.00
        return doubleArrayOf(kelvin, fahrenheit)
    }

    fun test() {
        println(convertTemperature(36.50).joinToString())
        println(convertTemperature(122.11).joinToString())
    }
}