package app.InputAdapters

import app.*
import java.io.File
import java.lang.RuntimeException

fun adapt(filePath: String) : Problem {
    val lines = File(filePath).readLines()
    val upperRightCoord = getCoord(lines[0])
    val scenario = Scenario(upperRightCoord)
    val robotsLines = lines.subList(1, lines.size)
    val robotsAndActions = getRobotsAndActions(robotsLines)
    return Problem(scenario, robotsAndActions)
}

fun getCoord(coord: String): Position {
    val coords = coord.split(" ").map { it.toInt() }
    if(coords.size != 2 || coords[0] <= 0 || coords[1] <= 0)
        throw RuntimeException("Bad input values")
    return Position(coords[0], coords[1])
}

fun getRobotsAndActions(robotsLines: List<String>): List<Pair<Robot, Queue<Action>>> {
    if (robotsLines.size % 2 != 0)
        throw RuntimeException("Bad input values")
    val linesPerRobot = robotsLines.chunked(2)
    return linesPerRobot.map {generateRobot(it)}
}

fun generateRobot(robotLines: List<String>): Pair<Robot, Queue<Action>> {
    val (coords, orientation) = getRobotStartingPositionAndOrientation(robotLines[0])
    val robot = Robot(coords, orientation)
    val movements = robotLines[1].toList().map { getActionFromString(it.toString()) }.toMutableList()
    val movementsQueue = Queue(movements)
    return Pair(robot, movementsQueue)
}

fun getRobotStartingPositionAndOrientation(data: String): Pair<Position, Orientation> {
    val dataChunks = data.split(" ")
    if(dataChunks.size != 3)
        throw RuntimeException("Bad input values")
    val startingCoords = Position(dataChunks[0].toInt(), dataChunks[1].toInt())
    val startingOrientation = getOrientationFromString(dataChunks[2])
    return Pair(startingCoords, startingOrientation)
}