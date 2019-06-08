package parallel.stepdefs

import cucumber.api.java8.En

class Stepdefs : En {
    init {
        Given("Step from {string} in {string} feature file") { scenario: String , file: String ->
            println("Thread ID - ${Thread.currentThread().id} - $scenario from $file feature file")
        }
    }
}