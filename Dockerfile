FROM openjdk:8
ADD target/test-0.0.1-SNAPSHOT.jar test-0.0.1-SNAPSHOT.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "test-0.0.1-SNAPSHOT.jar"]

# docker build -f Dockerfile -t testimage .
# docker run -p 8081:8087 testimage
# 8081 - Host port, 8087 - Container port
# Tomcat starts in 8087