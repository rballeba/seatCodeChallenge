package app

import java.lang.RuntimeException

enum class Orientation {
    North,
    South,
    Est,
    West;

    override fun toString(): String {
        return when(this) {
            North -> "N"
            South -> "S"
            West -> "W"
            Est -> "E"
        }
    }
}

fun getOrientationFromString(orientation: String): Orientation {
    return when(orientation) {
        "N" -> Orientation.North
        "S" -> Orientation.South
        "E" -> Orientation.Est
        "W" -> Orientation.West
        else -> throw RuntimeException("Bad orientation string")
    }
}
fun rotate90clockwise (orientation: Orientation): Orientation {
    return when(orientation) {
        Orientation.North -> Orientation.Est
        Orientation.Est -> Orientation.South
        Orientation.South -> Orientation.West
        Orientation.West -> Orientation.North
    }
}
fun rotate90antiClockwise (orientation: Orientation): Orientation {
    return when(orientation) {
        Orientation.North -> Orientation.West
        Orientation.Est -> Orientation.North
        Orientation.South -> Orientation.Est
        Orientation.West -> Orientation.South
    }
}

