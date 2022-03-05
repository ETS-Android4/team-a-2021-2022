package org.firstinspires.ftc.teamcode.auto

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.Disabled

@Autonomous(name = "Autonomous - Park (Red)")
class Autonomous_Park_Red: Autonomous_Park() {
    override fun isRed() = true
}

@Autonomous(name = "Autonomous - Park (Blue)")
class Autonomous_Park_Blue: Autonomous_Park() {
    override fun isRed() = false
}

@Autonomous(name = "Spare Duck (No Carousel) - Blue")
class DuckSpareAutonBlue: DuckSpareAuton() {
    override fun getColor() = Color.BLUE
}

@Autonomous(name = "Spare Duck (No Carousel) - Red")
class DuckSpareAutonRed: DuckSpareAuton() {
    override fun getColor() = Color.RED
}

@Autonomous(name = "MURDER Duck & Warehouse (Carousel) - Blue")
class DuckWarehouseAutonBlue: DuckWarehouseAuton() {
    override fun getColor() = Color.BLUE
}

@Autonomous(name = "MURDER Duck & Warehouse (Carousel) - Red")
class DuckWarehouseAutonRed: DuckWarehouseAuton() {
    override fun getColor() = Color.RED
}

@Autonomous(name = "MURDER Duck & Storage Area (Carousel) - Blue")
class DuckStorageUnitAutonBlue: DuckStorageUnitAuton() {
    override fun getColor() = Color.BLUE
}

@Autonomous(name = "MURDER Duck & Storage Area (Carousel) - Red")
class DuckStorageUnitAutonRed: DuckStorageUnitAuton() {
    override fun getColor() = Color.RED
}