# Desafio Datacom-api

## Pré requisitos
- #### Maven
````
mvn -v

Apache Maven 3.8.1
````
- #### Docker

````
docker -v

Docker version 20.10.6, build 370c289
````

- #### docker-compose

````
docker-compose -v

docker-compose version 1.29.1, build c34c88b2
````


- #### Java 8
````
java -version

openjdk version "1.8" 

## Ambiente Linux

### Executar os testes automatizados:

````
mvn test
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 
### Construir imagem 
```
docker build -t desafio .
``` 
### Subir stack
```
docker-compose -f docker-compose.yml up -d
``` 

## Ambiente Windows

### Executar os testes automatizados:

````
mvn test 
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 
### Construir imagem
```
docker build -t desafio .
``` 
### Subir stack
```
docker-compose -f docker-compose.yml up -d
``` 

# Swagger
http://localhost:8080/swagger-ui/

### Obter nome do produto

```
GET http://localhost:8080/dmview/nome
```


### Obter versão do produto

```
GET http://localhost:8080/dmview/versao
```

### Obter feature suportada do produto

```
GET http://localhost:8080/dmview/feature/{feature}
```

