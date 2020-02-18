FROM java:8-jre

ADD ./target/product-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/product-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080