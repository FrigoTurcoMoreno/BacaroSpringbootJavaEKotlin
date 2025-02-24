FROM gradle:jdk21 AS build

WORKDIR /gradle

COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts
COPY src src

RUN chmod +x gradlew

RUN ./gradlew clean build --no-daemon


FROM openjdk:21-jdk

WORKDIR /be

COPY --from=build /gradle/build/libs/*.jar /be/kotlinbackend.jar

CMD ["java", "-jar", "/be/kotlinbackend.jar"]