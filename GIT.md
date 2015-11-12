# Passo a Passo com o GIT

Neste documento listaremos alguns comandos úteis para poder utilizar a tecnologia de versionamento de código que estamos utilizando em nosso projeto: O GIT

## Forke o nosso projeto

- Primeiro, você precisará forkar o projeto para o seu perfil do github.
- Em seu computador, no diretório em que desejar criar o projeto, utilize o comando abaixo:
> git clone URL DO FORK

- Faça as alterações do projeto conforme a necessidade

##Preparando o seu commit
Para criar um commit e fazer o versionamento em seu computador, utilize a sequência de comandos abaixo:

*  git status (Irá exibir todos os arquivos que foram modificados/criados/excluidos)
* git add . (Irá "preparar o seu commit")
* git commit -m "titulo de seu commit"


Para enviar o seu commit e as alterações para seu Github, utilize o comando abaixo:
* git push origin master


##Enviando o seu Pull Request
Depois que seus arquivos estiverem no seu perfil do Github, você deverá clicar no botão "Create Pull Request".



##Verificando se você está com a versão mais atualizada do projeto: 
Se você for o criado do projeto, ou tiver as permissões necessárias dentro da organização, basta digitar o seguinte comando:
* git pull origin master

Isso irá atualizar todos os seus arquivos, de acordo com os arquivos que estiverem online.


##Sincronizando o seu Fork
Se você criou um fork do projeto, muito provavelmente na próxima vez em que você for modificar alguns arquivos, você não estará com a versão mais atual do projeto. A consequência disso poderá ser muito séria, uma vez que você está trabalhando com uma versão que nao é a mais atual. 
Utilize a sequência de códigos abaixo para solucionar o problema:

* git remote add nome_qualquer [URL do Projeto]
* git fetch nome_qualquer
* git merge nome_qualquer/master


Isso irá atualizar todos os seus arquivos, de acordo com os arquivos que estiverem online.





