package app

class Problem(private val scenario: Scenario, private val robotsAndActions: List<Pair<Robot, Queue<Action>>> ) {
    init {
        validateProblem()
    }
    private fun validateProblem() {
        fun validateRobotInitialPosition(robot: Robot, scenario: Scenario) {
            if(!scenario.positionIsInside(robot.position))
                throw RuntimeException("Robot is not inside given scenario")
        }
            robotsAndActions.forEach { validateRobotInitialPosition(it.first, scenario) }
    }
    fun run(): List<String> {
        return robotsAndActions.map { executeActionsInRobot(it.first, it.second) }
    }

    private fun executeActionsInRobot(robot:Robot, actions: Queue<Action>): String {
        while (!actions.isEmpty) {
            val actionToPerform = actions.dequeue()!!
            robot.executeAction(actionToPerform, scenario)
        }
        return robot.toString()
    }
}