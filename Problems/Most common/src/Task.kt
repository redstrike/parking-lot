fun main() {
    val words = mutableMapOf<String, Int>()
    var word = readLine()!!
    while (word != "stop") {
        words[word] = if (!words.containsKey(word)) 1 else words[word]!! + 1
        word = readLine()!!
    }
    if (words.isEmpty()) {
        return println(null)
    }
    println(words.maxBy { it.value }!!.key) // println(getMostFreqWord(words))
}

//fun getMostFreqWord(words: MutableMap<String, Int>): String {
//    var mostFreqWord = ""
//    var mostFreqCount = 0
//    for ((key, freqCount) in words) {
//        if (freqCount > mostFreqCount) {
//            mostFreqWord = key
//            mostFreqCount = freqCount
//        }
//    }
//    return mostFreqWord
//}
