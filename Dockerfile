FROM oracle/jdk:17-ol8 
WORKDIR /
ADD project-management-1.0.jar project-management-1.0.jar
EXPOSE 8080
CMD java -jar project-management-1.0.jar



