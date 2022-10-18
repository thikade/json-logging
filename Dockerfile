FROM registry.access.redhat.com/ubi9/openjdk-11:latest as builder
COPY . .
RUN mvn clean install

FROM registry.access.redhat.com/ubi9/openjdk-11-runtime:latest
COPY --from=builder /home/default/target/final/ .

ENV LOG4J_CONFIGURATION_FILE=log4j2-plaintext.xml

ENTRYPOINT [ "java", "-jar", "./json-logger.jar" ]
