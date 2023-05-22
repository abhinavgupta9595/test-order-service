FROM openjdk:11
ADD target/order-service.jar orderservice.jar
ENTRYPOINT ["java","-jar","/orderservice.jar"]