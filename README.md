# votacao-api

* Pré-requisto 
Banco de dados [Postgres 12]
Kafka 2.6.4

## Foi implementado os itens
1. Cadastro de pauta
2. Cadastro de associados
3. Abrir sessão de votação
4. Votação da pauta

## Integrações
1. Foi implementado a integração com sistema externo(Implementado todas a validações)
2. Implementado a mensageria(Kafka)(Quando a votação é encerrada é enviado o resultado para o tópico do kafka)
3. Implementado o versionamento das API's

## Logs
Coloquei Log somente nessa classe só para mostrar
NotificaoService.java 
