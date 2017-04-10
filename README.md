# zup-products

(Português do Brasil - pt_BR)

Este projeto foi desenvolvido para solucionar o problema proposto no exame de seleção da Zup.

# Tecnologias utilizadas

Para a elaboração do projeto, as seguintes tecnologias foram utilizadas:
* Linguagem de programação: Java (versão 1.8)
* Framework: Spring (Boot)
* Servidor de Aplicação: Tomcat (embedded)
* Testes Funcionais: Postman REST Client ([download](https://www.getpostman.com/))

# Arquitetura Proposta

Por se tratar de uma aplicação simples, foi desenvolvido um único módulo java com mini-serviços REST que executam em um servlet container embarcado (Tomcat) que disponibiliza os serviços.

A estrutura de pacotes se dá com um pacote "pai" que possui o script de inicialização da aplicação e outros 3 pacotes que seguem o modelo MVC.

A escolha do Spring (Boot) se deve à possibilidade de uma rápida implementação dentro do formato "microservice", já que a ferramenta oferece uma dinâmica de convenção-sobre-configuração (o que poupa o desenvolvedor de codificar toda a infraestrutura necessária para que possa focar no domínio do problema) e ao baixo acoplamento.

Uma classe de testes de integração foi desenvolvida (`br.com.ramonfacchin.ZupProductsApplicationTests.java`) para garantir o funcionamento da cadeia de chamadas no que diz respeito ao código Java escrito. Para a parte de comunicação Web, para ter certeza de que as chamadas REST funcionariam da forma esperada, foi criada uma coleção de chamadas compatível com o Postman REST Client que pode ser importada diretamente na aplicação.

## Pacote br.com.ramonfacchin.web

Este pacote possui o código responsável pelos Controladores da aplicação - isto é, as classes que tornarão os serviços disponíveis e que tratam da comunicação entre o cliente e a camada de modelo, responsável pelas tarefas de manipulação dos dados.

## Pacote br.com.ramonfacchin.service

Este pacote possui a parte mais complexa da camada de modelo, encarregada das operações de manipulação das classes de domínio (CRUD).

## Pacote br.com.ramonfacchin.domain

Este pacote possui a implementação do domínio do problema. Isto é: classes de entidade e DAOs necessários na resolução do problema.

# Requisitos para execução

Para executar o projeto você deve possuir:
* [Java Development Kit (variantes da versão 1.8 ou posterior)](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* [Variáveis de ambiente Java apropriadamente configuradas (guia para Windows)](http://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188)
* [Apache Maven](http://maven.apache.org/)
* Postman REST Client instalado para realizar os testes do que foi desenvolvido

# Executando o Projeto

Para executar o projeto, abra a linha de comando, navegue até o diretório raiz do projeto e execute os seguintes comandos (notação BASH):

`./mvnw package`

Isso fará com que o projeto seja compilado e empacotado em um JAR pronto para execução. Terminada a execução do comando, navegue até a pasta target (`cd target`) e execute:

`java -jar [nomeDoJarGerado.jar]`

Este comando fará com que a aplicação execute junto com servidor de aplicação embarcado. A aplicação ficará disponível em [http://localhost:8080/](http://localhost:8080/). Para testá-la leia a próxima seção.

# Testando o Projeto

Para testar o projeto, instale o Postman REST Client utilizando o link na seção *Tecnologias Utilizadas*. Feita a instalação, dentro do Postman, importe a coleção de chamadas REST que está contida no arquivo `[diretorio-do-projeto]/files/zup-products.postman_collection.json` para que possua todas as chamadas necessárias para os testes.

