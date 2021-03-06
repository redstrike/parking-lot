import java.util.Scanner

data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Client
        return this.name == other.name && this.age == other.age
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val name1 = scanner.next()
    val age1 = scanner.nextInt()
    val balance1 = scanner.nextInt()
    val name2 = scanner.next()
    val age2 = scanner.nextInt()
    val balance2 = scanner.nextInt()
    val client1 = Client(name1, age1, balance1)
    val client2 = Client(name2, age2, balance2)
    println(client1 == client2)
}
