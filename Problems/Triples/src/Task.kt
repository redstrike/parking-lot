import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val array = IntArray(size)
    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }
    var triplesCount = 0
    for (i in 0..array.lastIndex - 2) {
        if (array[i] + 1 == array[i + 1] && array[i] + 2 == array[i + 2]) {
            triplesCount++
        }
    }
    print(triplesCount)
}