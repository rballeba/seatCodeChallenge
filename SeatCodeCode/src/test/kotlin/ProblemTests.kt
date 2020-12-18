import app.InputAdapters.adapt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.RuntimeException


class ProblemTests {
    @Test fun `Happy path example works properly`() {
        val niceExampleFilepath = "./src/test/test-cases/1.txt"
        val problem = adapt(niceExampleFilepath)
        val results = problem.run()
        Assertions.assertEquals(results[0], "1 3 N")
        Assertions.assertEquals(results[1],"5 1 E")
    }
    @Test fun `Scenario does not allow negative squares outside the first quadrant`() {
        val negativeSemiplaneXExample = "./src/test/test-cases/negativeSemiplaneX.txt"
        val negativeSemiplaneYExample = "./src/test/test-cases/negativeSemiplaneY.txt"
        Assertions.assertThrows(RuntimeException::class.java) {
            adapt(negativeSemiplaneXExample)
        }
        Assertions.assertThrows(RuntimeException::class.java) {
            adapt(negativeSemiplaneYExample)
        }
    }
    @Test fun `Robot cannot be placed outside the scenario`() {
        val filepath = "./src/test/test-cases/robotPlacedOutsideScenario.txt"
        Assertions.assertThrows(RuntimeException::class.java) {
            adapt(filepath)
        }
    }
    @Test fun `Robot cannot going outside the scenario`() {
        val filepath = "./src/test/test-cases/robotGoingBeyondScenario.txt"
        val problem = adapt(filepath)
        Assertions.assertThrows(RuntimeException::class.java) {
            problem.run()
        }
    }
}