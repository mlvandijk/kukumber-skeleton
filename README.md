# Kukumber — Getting started with Cucumber in Kotlin

My team is creating an application in Kotlin. To make development of Cucumber tests easier, we decided to also use Cucumber-jvm with Kotlin instead of Java.
Fortunately, it is possible to use [cucumber-java8 in Kotlin](https://github.com/cucumber/cucumber-jvm/tree/master/kotlin-java8).

## Prerequisites

If you’d like to follow along, make sure you have the following installed:
- [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- An IDE; for instance [IntelliJ](https://www.jetbrains.com/idea/download/), which I use here.
- [Maven](https://maven.apache.org/)

## Add dependencies

We use Maven, so we added the following dependencies to our pom.xml:

```xml
    <properties>
        <cucumber.version>2.3.1</cucumber.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java8</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

Note: The cucumber-junit dependency is added so we can add a  JUnit Runner to run our tests, which we will do later. 

*If you don’t have Kotlin already configured in your project, you’ll need to add those dependencies also (or have IntelliJ do it for you).*

## Add a feature file

In our `src/test/resources` folder we create a new directory and add a .feature file. For this example, we’ll reuse the belly.feature from the [cucumber-java-skeleton](https://github.com/cucumber/cucumber-java-skeleton).

```gherkin
Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
```

Unfortunately the IntelliJ Cucumber plugin does not (yet) support a link between the steps in our feature file and our step definitions, like it does for Java.

Also, we cannot generate snippets in Kotlin directly. Fortunately there is a work around: we can run the tests to generate snippets in Java 8 lambda style. 

*You can run the test from IntelliJ by right-clicking the feature file and selecting “Run ‘Feature:belly’” from the context menu.*

When you run the tests, you should get something like the following result:

```
1 Scenarios (1 undefined)
3 Steps (3 undefined)
0m0.021s


You can implement missing steps with the snippets below:

Given("^I have (\\d+) cukes in my belly$", (Integer arg1) -> {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
});

When("^I wait (\\d+) hour$", (Integer arg1) -> {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
});

Then("^my belly should growl$", () -> {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
});


Process finished with exit code 0
```

## Add Step Definitions

In the `src/test/kotlin` folder, we add a new Kotlin File/Class, called `StepDefs`.
We only have to write a little Kotlin code in the file:

```kotlin
class StepDefs: En {

    init {
    }
}
```

Note that our StepDefs implement the `cucumber.api.java8.En` interface, so we need to import it:
`import cucumber.api.java8.En`

Now, when we copy-paste the generated snippets inside the `init{ }` block, IntelliJ offers to convert it to Kotlin for us. Once we do, we will also need to import the `cucumber.api.PendingException` mentioned in the snippets.

Now we have the StepDefs.kt file and we can start implementing the steps, as well as the code to make them pass!

## Add JUnit runner

To run our features from a JUnit runner, we’ll need to add one. In the `src/test/kotlin` folder, we add a new Kotlin File/Class, called RunKukesTest.

## Running tests from the command line

To run all tests use

    mvn test
