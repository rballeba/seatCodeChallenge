package app

class Scenario(val upperRightCoord: Position) {
    val lowerLeftCoord = Position(0,0)

    fun positionIsInside(position: Position): Boolean {
        val xIsValid = position.x >= lowerLeftCoord.x && position.x <= upperRightCoord.x
        val yIsValid = position.y >= lowerLeftCoord.y && position.y <= upperRightCoord.y
        if (xIsValid && yIsValid)
            return true
        return false
    }
}