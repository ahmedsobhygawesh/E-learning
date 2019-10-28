
#maven application developed by spring boot, spring data, H2, Lombok plugin

#using java 1.8

#for simplicity all the project under one package called com
    common: contains models
    repository: contains entities and repositories
    resources: the controller of the the project
    service: contains the logic and the business of the project

#using struct mapper for mapping between Models And Entities


#for opening the h2 console after running the project
http://localhost:8082/h2-console
with configuration data inside application.properties file

#there are logs using @Slf4j from lombok but not in all methods


#Note
1)deleted the StudentCourse record after unRegister but the best practise that put a flag like ACTIVE, DELETED
2)Miss the restrictions for prevent Duplicating of data



all endpoints:

1)
2)
3)
4)
5)
6)
7)