# TRIP-AWS Aplicação AWS SAM

Projeto de REST API para um serviço de voos.
OBS: foi utilizado como base o código abaixo:

https://github.com/iworks-education/study-datalake

## Requisitos

* [Installing, updating, and uninstalling the AWS CLI version 2](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)
* [Java SE Development Kit 8 installed](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Docker installed](https://www.docker.com/community-edition)
* [Maven](https://maven.apache.org/install.html)
* [SAM CLI](https://github.com/awslabs/aws-sam-cli)
* [Python 3](https://docs.python.org/3/)

## Processo de Instalação

### Instalando dependências

Utilize o `maven` para instalar as dependências e os pacotes e gerar os arquivos JAR:

```bash
mvn install
```

### Desenvolvimento local

**Executando a função localmente através da API de Gateway Local**
1. Iniciar o DynamoDB local em um container Docker. `docker run -p 8000:8000 -v $(pwd)/local/dynamodb:/data/ amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb -dbPath /data`
2. Criar a tabela no DynamoDB:
Copie e cole o conteúdo do arquivo /srv/test/java/database.txt no prompt de comando (Create Database:).

Se a tabela existir, você pode deletar:
Copie e cole o conteúdo do arquivo /srv/test/java/database.txt no prompt de comando (Delete Database:).


3. Iniciar a API SAM local.
 - Em um Mac: `sam local start-api --env-vars src/test/resources/test_environment_mac.json`
 - Em um Windows: `sam local start-api --env-vars src/test/resources/test_environment_windows.json`
 
 OBS:  Se você já tem um container localmente (no seu caso o java java8), você pode utilizar a opção --skip-pull-image para remover o download.

Se todos os comando acima executarem com sucesso, você pode acessar a API do seu endpoint localmente. Por exemplo, consultar um Trip. No endpoint abaixo:
`GET http://localhost:3000/trips/findByCountry?country=Brasil`.
Se ele retornar um código 404. Agora você pode explorar todos os endpoints, para isso, utilize o arquivo src/test/java/Trip AWS.json para importar a Coleção da API Rest no Postman.
