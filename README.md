### FCamara 🚀

"A Força do Professor

Um guerreiro sem espada
sem faca, foice ou facão
armado só de amor
segurando um giz na mão
o livro é seu escudo
que lhe protege de tudo
que possa lhe causar dor
por isso eu tenho dito
Tenho fé e acredito
na força do professor.

Ah... se um dia governantes
prestassem mais atenção
nos verdadeiros heróis
que constroem a nação
ah... se fizessem justiça
sem corpo mole ou preguiça
lhe dando o real valor
eu daria um grande grito
Tenho fé e acredito
na força do professor.

Porém não sinta vergonha
não se sinta derrotado
se o nosso país vai mal
você não é o culpado
Nas potências mundiais
são sempre heróis nacionais
e por aqui sem valor
mesmo triste e muito aflito
Tenho fé e acredito
na força do professor.

Um arquiteto de sonhos
Engenheiro do futuro
Um motorista da vida
dirigindo no escuro
Um plantador de esperança
plantando em cada criança
um adulto sonhador
e esse cordel foi escrito
porque ainda acredito
na força do professor.."
Por: **Bráulio Bessa**

## Estrutura do Projeto
O projeto será dividido em três módulos principais:

	1.	Cadastro do Estabelecimento (CRUD completo)
	2.	Cadastro de Veículos (CRUD completo)
	3.	Controle de Entrada e Saída de Veículos (registro de entrada/saída e relatórios)

Além disso, teremos um módulo de autenticação, usando JWT (2 etapa), e a integração com o Flyway para migrações de banco de dados Postgres.
## Dependências
•	Spring Web
•	Spring Data JPA
•	Postgres Database 
•	Flyway Migration
•	Spring Security (para autenticação)
•	Lombok (para reduzir código boilerplate)
•	Springdoc OpenAPI (para Swagger)

## Nome do Projeto: **ParkWise**
## Swagger
http://localhost:8080/ParkWise/swagger-ui/index.html#/

## TDD (Test-Driven Development)
- **Teste para criarEstabelecimento no EstabelecimentoController**;
- **Teste para criarVeiculo no VeiculoController**;
- **Teste para registrarEntrada no EntradaSaidaController**;

## Requisitos
- Todos os endpoints estão retornando JSON e XML devido a dependência jackson-dataformat-xml no pom.xml
- Requisições GET, POST, PUT ou DELETE funcionando.
- Coloquei já o Spring Secrurity nas ainda não habilitei tudo ainda comentado, v2

### 1. GraphQL (Implementação BFF - Backend For Frontend)

**Não possuo experiencia em GraphQL, mas posso aprender**

### 2. Banco de Dados (Nível Básico)

Resposta 1:

Imagina que um banco de dados relacional é como uma cidadezinha organizada. As tabelas são como prédios: cada prédio (tabela) tem moradores (linhas) com características específicas, como nome e idade (colunas).

	•	Chave Primária: Essa é como o RG de cada morador. Ninguém tem o mesmo e ele garante que cada um é único. Em uma tabela, a chave primária é o que identifica cada linha sem chance de erro.
	•	Chave Estrangeira: Sabe aquele prédio onde só entra quem é amigo de alguém que já mora lá? A chave estrangeira faz isso entre as tabelas. Ela conecta uma tabela a outra, tipo uma “indicação” para o morador que pertence a outro prédio. É o que liga tudo em uma grande rede de informações.

Resposta 2:

Pra montar o sistema de um estacionamento, imagina que a gente tem três blocos de informação:

	1.	Bloco dos Estacionamentos – Aqui é onde ficam os dados do estacionamento em si, como o nome, quantas vagas tem pra carro e moto, endereço, telefone, etc. Imagina uma tabela chamada Estabelecimento onde cada linha é um estacionamento diferente.
	2.	Bloco dos Veículos – Agora temos o prédio dos veículos. Cada carro ou moto que entra ganha uma ficha com marca, modelo, cor, placa e tipo (se é carro ou moto). Esse bloco é a tabela Veiculo, e cada linha aqui é um veículo que passa pelo estacionamento.
	3.	Bloco de Controle de Entradas e Saídas – Esse é tipo uma “portaria”, registrando a entrada e saída dos veículos. Aqui a gente liga o veículo ao estacionamento e marca os horários de entrada e saída, criando o nosso “histórico de visita”.

No final das contas, com essas três tabelas conectadas, a gente consegue ver quem entrou e saiu, quanto tempo ficou e ainda monitorar a ocupação do estacionamento. Simples e eficiente!

Resposta 3:

Então, e se a gente resolvesse fazer isso tudo num banco de dados NoSQL, em vez do relacional?

Vantagens:

	•	Crescimento na Horizontal
	•	Flexibilidade de Dados
	•	Desempenho em Massa

Desvantagens:

	•	Relações Complicadas
	•	Consistência
	•	Consultas Complexas


### 3. Agilidade (Nível Básico)

Resposta 1:

Metodologias ágeis são tipo o jeito moderno de construir software. Em vez de esperar meses pra entregar o projeto inteiro, como numa maratona, o Agile divide o trabalho em várias corridinhas curtas chamadas sprints. Cada sprint é uma entrega, com uma funcionalidade ou melhoria pronta e funcionando.

Pensar em Agile é lembrar de:

	•	Adaptação
	•	Colaboração
	•	Entrega rápida


Resposta 2:

Alguns princípios ágeis.

	1.	Dividir em Pequenos Blocos 
	2.	Reuniões Curtas e Constantes 
	3.	Feedback Rápido 


Resposta 3:

Comunicação é o coração de um ambiente ágil. Imagina tentar fazer um jantar em grupo sem conversar com ninguém. Cada um vai acabar fazendo um prato diferente, sem saber o que o outro tá preparando. No desenvolvimento ágil, sem comunicação, cada um pode acabar indo pra um lado diferente também.

Boas práticas:

	1.	Daily Stand-Up
	2.	Retrospectiva
	3.	Ferramentas de Comunicação (Slack, Jira, Trello)


### 4. DevOps (Nível Básico)


Resposta 1:

DevOps é como aquele vizinho “faz-tudo” no prédio. DevOps acelera o ciclo de vida da aplicação, faz tudo fluir melhor e evita aquele clássico “jogo de empurra” entre desenvolvedores e o pessoal de operações.

Resposta 2:

Para botar DevOps no projeto ParkWise, usando algumas práticas bem práticas:

	1.	Integração Contínua (CI): Toda vez que alguém faz uma alteração no código, ela é automaticamente testada e integrada no projeto. Tipo uma verificação de qualidade. Exemplo: usando GitHub Actions ou Jenkins, cada vez que alguém faz um “push” no código, o sistema já roda os testes e garante que nada quebrou.
	2.	Entrega Contínua (CD): Depois que o código passa nos testes, ele é automaticamente preparado pra deploy. Se tá tudo certo, a aplicação já vai pro ambiente de produção, meio que num “passe de mágica”. Então, qualquer melhoria ou correção que a gente faz vai rápido pro usuário final.

Pra esse projeto de estacionamento, a gente poderia configurar o CI/CD assim: cada vez que sai uma nova funcionalidade, ela é testada, validada e pronta pra produção de maneira automática. Isso agiliza as entregas e mantém a qualidade lá em cima.

Resposta 3:

Pra automatizar o deploy/monitorar essa aplicação, a gente pode usar algumas ferramentas que são tipo “as armas secretas” do DevOps:

	1.	Docker
	2.	Jenkins ou GitHub Actions
	3.	Kubernetes (sonho de qualque dev)
	

**É tudo obrigado**