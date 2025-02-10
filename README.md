### Requisitos do ambiente
+ [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html). Necessária versão 8.0 ou superior
+ [Apache Maven](https://maven.apache.org/). Recomendada versão 3.6.1

### 1. A aplicação

O UniqueDigit é uma aplicação responsável por gerenciar a lógica de negócios relacionada ao cálculo e armazenamento de "dígitos únicos". A aplicação utiliza repositórios, cache em memória e um mapeador de modelos para realizar suas operações.

### 2. Como compilar e executar os testes unitários
Navegue pela linha de comando até o diretório "root" do código-fonte e execute o seguinte comando para que o aplicativo seja compilado.
Durante a compilação, todas as dependências serão baixadas para o repositório local do Maven, e os testes unitários serão executados.
```
mvn clean install
```
### 3. Como executar
Navegue pela linha de comando até o diretório "root" do código-fonte e execute o seguinte comando para que o aplicativo seja executado.
```
mvn spring-boot:run
```
Por padrão, o acesso à API será pelo endereço http://localhost:8080/ e a interface swagger em http://localhost:8080/swagger-ui.html#/

Lembre-se de utilizar o endpoint para fornecer a chave pública para a API, sem esta chave não é possível inserir registros de usuario, uma vez que estes são criptografados
##### Contato
Email: lucascicutti1995@gmail.com

Telefone: (31)99299-0400
