# Java + Spring Boot App

### Requisitos

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org/download.cgi)

Configurar devidademte as variáveis de ambiente
- JAVA_HOME
- MAVEN_HOME
- PATH

### Executando Localmente

```shell
mvn clean install
```

```shell
mvn spring-boot:run
```

### Executando via docker

```shell
mvn clean package -P prod
```

```shell
docker-compose up -d
```

### Acesso

* Para acessar o swagger aplicação -> [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Postman collection

* Arquivo - ./api-java-springboot.postman_collection.json

## Autor
Wilker de Jesus Machado
Email: <wilkerjmachado@gmail.com>