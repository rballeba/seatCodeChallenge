package app

import java.lang.RuntimeException

enum class Action {
    TurnLeft,
    TurnRight,
    MoveForward
}

fun getActionFromString(action: String): Action {
    return when(action) {
        "L" -> Action.TurnLeft
        "R" -> Action.TurnRight
        "M" -> Action.MoveForward
        else -> throw RuntimeException("Bad action string")
    }
}