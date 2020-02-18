FROM java:8-jre

ADD ./target/price-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/price-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081