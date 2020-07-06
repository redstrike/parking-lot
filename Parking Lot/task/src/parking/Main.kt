package parking

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var parkingLot = ParkingLot()
    while (true) {
        when (scanner.next()) {
            "create" -> parkingLot = ParkingLot(scanner.nextInt())
            "park" -> parkingLot.park(Car(scanner.next(), scanner.next()))
            "leave" -> parkingLot.leave(scanner.nextInt())
            "status" -> parkingLot.status()
            "reg_by_color" -> parkingLot.searchByColor(scanner.next(), "regNum")
            "spot_by_color" -> parkingLot.searchByColor(scanner.next(), "spotNum")
            "spot_by_reg" -> parkingLot.searchByRegNum(scanner.next())
            "exit" -> return
        }
    }
}

data class Car(val regNum: String, val color: String)

class ParkingLot(private val numberOfSpots: Int = 0) {
    private val spots = Array(numberOfSpots) { "" }

    init {
        if (numberOfSpots > 0) {
            println("Created a parking lot with $numberOfSpots spots.")
        }
    }

    private fun isZeroSpotLot(): Boolean {
        if (numberOfSpots > 0) return false
        println("Sorry, a parking lot has not been created.")
        return true
    }

    fun park(car: Car) {
        if (isZeroSpotLot()) return
        for (i in spots.indices) {
            if (spots[i].isEmpty()) {
                val spotNo = i + 1
                spots[i] = "$spotNo ${car.regNum} ${car.color}"
                println("${car.color} car parked in spot $spotNo.")
                break
            }
            if (i == spots.size - 1 && spots[i].isNotEmpty()) {
                println("Sorry, the parking lot is full.")
            }
        }
    }

    fun leave(leaveSpot: Int) {
        if (isZeroSpotLot()) return
        spots[leaveSpot - 1] = ""
        println("Spot $leaveSpot is free.")
    }

    fun status() {
        if (isZeroSpotLot()) return
        var occupiedSpots = 0
        for (spot in spots) {
            if (spot != "") {
                println(spot)
                occupiedSpots++
            }
        }
        if (occupiedSpots == 0) {
            println("Parking lot is empty.")
        }
    }

    fun searchByColor(carColor: String, printData: String) {
        if (isZeroSpotLot()) return
        val color = carColor.toUpperCase()
        val dataIndex = if (printData == "regNum") 1 else 0 // 0 -> spotNum
        var matchedColorSpots = 0
        for (spot in spots) {
            if (spot.toUpperCase().endsWith(color)) {
                val carData = spot.split(" ")[dataIndex] // 0 -> spotNum, 1 -> regNum
                print("${if (matchedColorSpots > 0) ", " else ""}$carData")
                matchedColorSpots++
            }
        }
        if (matchedColorSpots == 0) {
            println("No cars with color $color were found.")
        } else println()
    }

    fun searchByRegNum(regNum: String) {
        if (isZeroSpotLot()) return
        var matchedRegNumSpots = 0
        for (spot in spots) {
            if (spot.isEmpty()) {
                continue
            }
            val spotInfo = spot.split(" ")
            val spotNo = spotInfo[0]
            val carRegNum = spotInfo[1]
            if (carRegNum == regNum) {
                print("${if (matchedRegNumSpots > 0) ", " else ""}$spotNo")
                matchedRegNumSpots++
            }
        }
        if (matchedRegNumSpots == 0) {
            println("No cars with registration number $regNum were found.")
        } else println()
    }
}
