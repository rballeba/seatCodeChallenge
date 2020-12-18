# Seat Code Problem
This is the solution provided by Ruben Ballester Bautista to the Seat Code recruiting challenge.

As you can see, I have used as tech stack Kotlin 1.4.21 (latest) and JUnit 5.7.0 with Maven as project manager (I have decided to use Kotlin because in the offer it was written that knowing Kotlin was a plus, but I'm really very curious about Scala as it can be used as a functional language). 

There are some code decissions that can be changed or reconsidered. I'm not specially sure that decoupling the Robot class from the Scenario class is a nice idea (in other words, not having robots in our scenario and using scenario only as data class boundary for the game). However, I thought that in complex scenarios we wouldn't have a well defined grid, so I decided finally to use the approach of having only scenario as an optional boundary to let the Robot class be more extensible.

Another feature that I have included are the tests. I have added some tests about input coherence and format. Moreover, I have added the test that checks that the given input in the code challenge has exactly the expected output written in the challenge too. There are plenty of tests that I haven't added that can be useful too,  but I haven't added them due to I thought that this was not the goal of the problem (although I considered that you would appreciate the fact that I think testing is a fundamental part of coding as well).

# Compilation

As the project is wrapped using Maven, compiling it is very easy. Inside the root folder of the project, `<root>/SeatCodeCode` you only need to execute `mvn clean` and `mvn package`: the first instruction will clean the output folder and the second one will generate the production jar inside the folder `<root>/SeatCodeCode/target` with the name `SeatCodeCode-1.0-jar-with-dependencies.jar` and will run all tests (that can be run independently with the command `mvn test` too).

# Execution
To execute the production jar, you only need to do:

    java -jar target/SeatCodeCode-1.0-jar-with-dependencies.jar "absolute/path/to/the/input/file.txt"

from the folder `<root>/SeatCodeCode`. Note tat if you don't add a path you will execute the default example that is included in the PDF of the challenge.
