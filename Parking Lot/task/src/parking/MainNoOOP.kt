//package parking
//
//    import java.util.Scanner
//
//    val scanner = Scanner(System.`in`)
//    var spots = Array(0) { "" }
//
//    fun main() {
//        loop@ while (true) {
//            when (scanner.next()) {
//                "create" -> {
//                    val numSpots = scanner.nextInt()
//                    spots = Array(numSpots) { "" }
//                    println("Created a parking lot with $numSpots spots.")
//                }
//                "park" -> {
//                    if (checkEmptyLot(spots)) continue@loop
//                    val carRegNum = scanner.next()
//                    val carColor = scanner.next()
//                    for (i in spots.indices) {
//                        if (spots[i].isEmpty()) {
//                            val spotNo = i + 1
//                            spots[i] = "$spotNo $carRegNum $carColor"
//                            println("$carColor car parked in spot $spotNo.")
//                            break
//                        }
//                        if (i == spots.size - 1 && spots[i].isNotEmpty()) {
//                            println("Sorry, the parking lot is full.")
//                        }
//                    }
//                }
//                "leave" -> {
//                    if (checkEmptyLot(spots)) continue@loop
//                    val leaveSpot = scanner.nextInt()
//                    spots[leaveSpot - 1] = ""
//                    println("Spot $leaveSpot is free.")
//                }
//                "status" -> {
//                    if (checkEmptyLot(spots)) continue@loop
//                    var occupiedSpots = 0
//                    for (spot in spots) {
//                        if (spot != "") {
//                            println(spot)
//                            occupiedSpots++
//                        }
//                    }
//                    if (occupiedSpots == 0) {
//                        println("Parking lot is empty.")
//                    }
//                }
//                "reg_by_color" -> searchByColor("regNum")
//                "spot_by_color" -> searchByColor("spotNum")
//                "spot_by_reg" -> {
//                    if (checkEmptyLot(spots)) continue@loop
//                    val regNum = scanner.next()
//                    var matchedRegNumSpots = 0
//                    for (spot in spots) {
//                        if (spot.isEmpty()) {
//                            continue
//                        }
//                        val spotInfo = spot.split(" ")
//                        val spotNo = spotInfo[0]
//                        val carRegNum = spotInfo[1]
//                        if (carRegNum == regNum) {
//                            print("${if (matchedRegNumSpots > 0) ", " else ""}$spotNo")
//                            matchedRegNumSpots++
//                        }
//                    }
//                    if (matchedRegNumSpots == 0) {
//                        println("No cars with registration number $regNum were found.")
//                    } else println()
//                }
//                "exit" -> return
//            }
//        }
//    }
//
//    private fun searchByColor(printData: String) {
//        if (checkEmptyLot(spots)) return
//        val color = scanner.next().toUpperCase()
//        val dataIndex = if (printData == "regNum") 1 else 0 // 0 -> spotNum
//        var matchedColorSpots = 0
//        for (spot in spots) {
//            if (spot.toUpperCase().endsWith(color)) {
//                val carData = spot.split(" ")[dataIndex] // 0 -> spotNum, 1 -> regNum
//                print("${if (matchedColorSpots > 0) ", " else ""}$carData")
//                matchedColorSpots++
//            }
//        }
//        if (matchedColorSpots == 0) {
//            println("No cars with color $color were found.")
//        } else println()
//    }
//
//    private fun checkEmptyLot(spots: Array<String>): Boolean {
//        if (spots.isEmpty()) {
//            println("Sorry, a parking lot has not been created.")
//            return true
//        }
//        return false
//    }
