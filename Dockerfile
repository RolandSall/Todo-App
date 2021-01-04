FROM openjdk:11
VOLUME /tmp
ADD  target/todo-app.jar todo-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/todo-app.jar"]