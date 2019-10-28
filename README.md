
#maven application developed by spring boot, spring data, H2, Lombok plugin
#you can take a look on Rest Requests in the below

#using JDK 1.8

#open project as maven project
    -download pom file dependencies
    -edit configuration with select jdk, and main class
    -clean install Run

#for simplicity all the project under one package called com
    common: contains models
    repository: contains entities and repositories
    resources: the controller of the the project
    service: contains the logic and the business of the project

#test case for student register in class SpringBootWithH2ApplicationTests

#using struct mapper for mapping between Models And Entities


#for opening the h2 console after running the project
http://localhost:8082/h2-console
with configuration data inside application.properties file

#there are logs using @Slf4j from lombok


#Note
1)deleted the StudentCourse record after unRegister but the best practise that put a flag like ACTIVE, DELETED
2)Miss the restrictions for prevent Duplicating of data



all endpoints:
use POSTMAN or any another Rest tool

1) student register just email and password that are mandatory
localhost:appPort/students/register :-post
{
"email" : "Alex@a.com",
"password": "123",
"gender": "",
"dob"  ""
}


2) student login
localhost:appPort/students/login :-post
{
"email" : "Alex@a.com",
"password": "123"
}


3) save a new course
localhost:appPort/courses :-post
{
	"name": "math" ,
	"description": "for kids"
}


4) get specific student's courses
localhost:8082/courses/students/{studentId} :-get

5) register student on course
localhost:8082/courses/{courseId}/students/{studentId}/register :- post

6) unregister student from course
localhost:8082/courses/{courseId}/students/{studentId}/un-register :-post

7) get all courses
localhost:8082/courses :-get