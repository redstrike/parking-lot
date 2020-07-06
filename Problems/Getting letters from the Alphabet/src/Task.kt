import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    val char = input.next().first()
    for (character in 'a' until char) {
        print(character)
    }
}