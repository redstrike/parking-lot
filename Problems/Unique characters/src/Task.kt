fun main() {
    val word = readLine()!!
    var uniqueChars = 0
    for (char in word.toSet()) {
        val charCount = word.count { it == char }
        if (charCount == 1) {
            uniqueChars++
        }
    }
    print(uniqueChars)
}
