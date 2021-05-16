FROM openjdk:8
VOLUME /tmp
EXPOSE 9090
COPY NuvuClientes-1.0.0.jar /NuvuClientes-1.0.0.jar
ENTRYPOINT ["java","-jar","NuvuClientes-1.0.0.jar"]