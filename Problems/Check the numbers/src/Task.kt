import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val array = IntArray(size)
    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    if (!array.contains(n) || !array.contains(m)) {
        return print("YES")
    }
    for (i in 0 until array.lastIndex) {
        if (array[i] == n && array[i + 1] == m || array[i] == m && array[i + 1] == n) {
            return print("NO")
        }
    }
    print("YES")
}