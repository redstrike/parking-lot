fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House.build(rooms, price)
    println(house.totalPrice())
}

open class House(val rooms: Int, val price: Int, val coefficient: Double) {
    companion object {
        fun build(rooms: Int = 0, price: Int = 0): House {
            return when (rooms) {
                in Int.MIN_VALUE..1 -> Cabin(rooms, price)
                in 2..3 -> Bungalow(rooms, price)
                4 -> Cottage(rooms, price)
                in 5..7 -> Mansion(rooms, price)
                else -> Palace(rooms, price)
            }
        }
    }

    fun totalPrice(): Int {
        return (price.coerceIn(0, 1_000_000) * coefficient).toInt()
    }
}

class Cabin(rooms: Int, price: Int) : House(rooms, price, 1.0)
class Bungalow(rooms: Int, price: Int) : House(rooms, price, 1.2)
class Cottage(rooms: Int, price: Int) : House(rooms, price, 1.25)
class Mansion(rooms: Int, price: Int) : House(rooms, price, 1.4)
class Palace(rooms: Int, price: Int) : House(rooms, price, 1.6)

//    fun main() {
//        val rooms = readLine()!!.toInt()
//        val price = readLine()!!.toInt()
//        val house = House(rooms, price)
//        println(house.totalPrice())
//    }
//
//    class House(val rooms: Int, val price: Int) {
//        val coefficient: Double = when (rooms) {
//            in Int.MIN_VALUE..1 -> 1.0 // Cabin
//            in 2..3 -> 1.2 // Bungalow
//            4 -> 1.25 // Cottage
//            in 5..7 -> 1.4 // Mansion
//            else -> 1.6 // Palace
//        }
//        val basePrice = price.coerceIn(0, 1_000_000)
//
//        fun totalPrice(): Int = (basePrice * coefficient).toInt()
//    }