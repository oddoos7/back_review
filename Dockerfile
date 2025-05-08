# OpenJDK 21 기반으로 실행
FROM openjdk:21-jdk-slim

# JAR 파일을 컨테이너로 복사
COPY build/libs/review-0.0.1-SNAPSHOT.jar review-service.jar

# 컨테이너가 실행될 때 수행할 명령어
ENTRYPOINT ["java", "-jar", "/review-service.jar"]
