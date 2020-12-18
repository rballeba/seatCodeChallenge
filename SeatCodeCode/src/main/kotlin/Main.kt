import app.InputAdapters.adapt
import java.io.File

const val defaultFilepath = "./src/test/test-cases/1.txt"

fun main(vararg args: String) {
    val fileToAnalyze = if(args.isNotEmpty()) args[0] else defaultFilepath
    if(File(fileToAnalyze).exists()) {
        val problem = adapt(fileToAnalyze)
        problem.run().forEach { println(it) }
    }
    else
        print("The input is not correct. Please, provide as argument an absolute (or relative to the root of the project) " +
                "path to the file to analyze")
}