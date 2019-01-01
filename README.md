# Funny Quiz

Quiz game with final file for download. Designed to watch on mobile.

## Getting Started

### Prerequisites

You only need maven with java 1.8

### Configuration

Go to src/main/resources/ and edit quiz.properties configuration file

```
# Name of target person
quiz.target-person=Pepe
# Name of the file for reward
quiz.award-file-name=award.pdf

# Password text suggestion
quiz.password-text=Para poder proseguir tu contraseña has de escribir
# Password for access the quiz
quiz.password=123456

# Congratulations text
quiz.congrats-text=Enhorabuena ¡Que lo disfrutes!

# Quiz questions. "##" separator for multiples correct answer
quiz.questions[0].question=¿Cuantos años cumples?
quiz.questions[0].help=Son un porrón...
quiz.questions[0].error=Venga ya, no te pongas menos!
quiz.questions[0].success=¡Correcto!
quiz.questions[0].response=43##cuarenta y tres##cuarentaytres

quiz.questions[1].question=Tengo un cimbrel matutino con la forma de un...
quiz.questions[1].help=Refranero popular...
quiz.questions[1].error=Dice el refranero popular
quiz.questions[1].success=Esta era buena, ¡Siguiente! 
quiz.questions[1].response=pepino
```

Add questions as you like, following the example.

### Install and Deploy

Clone project

```
git clone https://github.com/pwatfe/funnyquiz.git
```

Compile & package

```
mvn clean package
```

Run

```
mvn spring-boot:run
```
or 
```
java -jar target/quiz-1.0.0.jar
```

Access to http://localhost:8080, take a look at quiz.properties file to see default configuration.


## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Bootstrap](https://getbootstrap.com/docs/4.1/getting-started/introduction/) - Used in view layer


