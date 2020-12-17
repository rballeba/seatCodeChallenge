package app

class Robot(var position: Position, var orientation: Orientation) {
    fun executeAction(action: Action, scenario: Scenario? = null) {
        when(action) {
            Action.MoveForward ->  {
                val newPosition = getMoveForwardPosition()
                if (scenario != null) {
                    if(!scenario.positionIsInside(newPosition))
                        throw RuntimeException("New robot position is not valid in the given scenario")
                }
                position = newPosition
            }
            Action.TurnRight -> orientation = rotate90clockwise(orientation)
            Action.TurnLeft -> orientation = rotate90antiClockwise(orientation)
        }
    }
    private fun getMoveForwardPosition(): Position {
        return when(orientation) {
            Orientation.West -> Position(position.x - 1, position.y)
            Orientation.Est -> Position(position.x + 1, position.y)
            Orientation.North -> Position(position.x, position.y + 1)
            Orientation.South -> Position(position.x, position.y -1)
        }
    }
    override fun toString(): String {
        return "${position.x} ${position.y} $orientation"
    }
}