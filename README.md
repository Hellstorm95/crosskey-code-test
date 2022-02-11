# crosskey-code-test

## File Structure
files/prospect.txt: the prospect list file given with the description
src/main/java/org/mortage/mortagecalculator: directory for the application java files
src/test/java/org/mortage/mortagecalculator: directory for the test java file
src/main/resources/templates: directory for the html templates for the web application
Dockerfile: The dockerfile used to create the docker image

## Test locally 
### Directly with Maven
1: Command to test locally: mvnw spring-boot: run
2: Once started go to your browser and use the url: http://localhost:8081/showprospects

### Building jar and running it
This method will compile, build, test and run the application
1: mvnw clean package
2: java -jar target/mortagecalculator-0.0.1.jar
3: Once started go to your browser and use the url: http://localhost:8081/showprospects

To test locally you need Maven and java 17. I used openjdk 17

## Test locally with Docker
1: docker build -t mortagecalculator .
2: docker run -p 8081:8081 mortagecalculator
3: Once started go to your browser and use the url: http://localhost:8081/showprospects

## Test on AWS
Link to application: http://ec2-3-122-205-235.eu-central-1.compute.amazonaws.com/showprospects
The link worked when I implemented the application. Please Let me know if the link is not working for some reason

I used windows opertating system for local testing and devlopment. 
If you have any question, please let me know. 
