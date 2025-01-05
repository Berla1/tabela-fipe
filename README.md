# Tabela Fipe

Este projeto é uma aplicação Java que consome a API pública da Tabela Fipe para obter informações sobre marcas, modelos e preços de veículos no Brasil.

## Funcionalidades

- Listar todas as marcas de veículos disponíveis.
- Listar os modelos de uma marca específica.
- Obter detalhes e preços de um modelo específico.

## Pré-requisitos

- Java 11 ou superior instalado.
- Maven para gerenciamento de dependências.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/Berla1/tabela-fipe.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd tabela-fipe
   ```

3. Compile o projeto usando Maven:

   ```bash
   mvn clean install
   ```

4. Execute a aplicação:

   ```bash
   java -jar target/tabela-fipe-1.0-SNAPSHOT.jar
   ```

## Uso

Após iniciar a aplicação, você poderá:

- Visualizar a lista de marcas disponíveis.
- Selecionar uma marca para ver os modelos correspondentes.
- Selecionar um modelo para obter detalhes e preços atualizados.


## Referências

- [API da Tabela Fipe](https://parallelum.com.br/fipe/api/v1/carros/marcas)
- [Fundação Instituto de Pesquisas Econômicas (Fipe)](https://www.fipe.org.br/)
