# votacao-api
* Solução back-end para gerenciar sessões de votação.

* Pré-requisto 
 [Postgres 12]
 [Kafka 2.6.4]

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

## APIs criadas
1. /api/1.0/abertura
2. /api/1.0/associado
3. /api/1.0/pauta
4. /api/1.0/voto
