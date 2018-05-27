# VoteFrontEnd
	Por que só podemos votar a cada 4 anos em uma era onde tudo é online?

## Como executar:
	Como gerar a versão de produção (back-end/front-end):
		1. execute 'mvn clean install' na pasta do raiz do back-end
		2. execute o comando 'java -jar ./target/{jar_gerado} --server.port=80' na pasta

### Proximas features:
	[ ] Implementar funcionalidade de descandidatar
	[ ] Implementar criptografia que apenas o vontante identifique o proprio voto
	[ ] Implementar botão: "Nenhum destes candidatos"
    [ ] Implementar suporte a governadores
   	[ ] Criar arquivo de configuração de banco
	[ ] Adicionar ferramenta de log

### TODO Portal:
#### Tela institucional		
	[ ] Criar pagina institucional

#### Tela de Login
	[ ] Adicionar rodapé	

#### Tela de Logon
	[ ] Adicionar rodapé	

#### Tela principal
	[ ] Adicionar % parcial da eleição
	[ ] Limitar a quantidade de candidatos na tela
	[ ] Implementar atualização em tempo real da votação
#### Todas
	[ ] Configurar responsividade
	[ ] Criar icone para o aplicativo
	[ ] Criar componente de notificação

### FIXME back-end
	[ ] Resolver FIXME do CSRF
