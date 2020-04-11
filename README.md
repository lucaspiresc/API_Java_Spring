### Requisitos do ambiente
+ [Java Development Kit (JDK)](https://maven.apache.org/). Necessária versão 8.0 ou superior
+ [Apache Maven](https://maven.apache.org/). Recomendada versão 3.6.1

### 1. Como compilar e executar os testes unitários
Navegue pela linha de comando, posicione no diretório "root" do código-fonte e execute o seguinte comando para que o aplicativo seja compilado.
Durante a compilação, todas as dependências serão baixadas para o repositório local do Maven, bem como executados os testes unitários serão executados.
```
mvn clean install
```
### 2. Como executar
Navegue pela linha de comando, posicione no diretório "root" do código-fonte e execute o seguinte comando para que o aplicativo seja executado.
```
mvn spring-boot:run
```
Por padrão, o acesso à API será pela porta 8080: http://localhost:8080/ e a interface swagger em http://localhost:8080/swagger-ui.html#/

Lembre-se de utilizar o endpoint para fornecer a chave pública para a API, sem esta chave não é possível inserir registros de usuario, uma vez que estes são criptografados
##### Contato
Email: lucascicutti1995@gmail.com
Telefone: (31)99299-0400
