
import cucumber.api.PendingException
import cucumber.api.java8.En

class StepDefs: En {

    init {
        Given("^I have (\\d+) cukes in my belly$") { arg1: Int ->
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        When("^I wait (\\d+) hour$") { arg1: Int ->
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        Then("^my belly should growl$") {
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }
    }
}