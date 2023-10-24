#language: pt

Funcionalidade: Cadastro de usuário

Como um visitante
Quero me cadastrar no sistema
Para ter acesso às funcionalidades restritas

@cadastrar
Cenário: Cadastro com sucesso

Dado que estou na tela de cadastro de usuário
E preencho o campo nome "Testador" com um nome válido
E preencho o campo "testador@testador.com" com um e-mail válido
E preencho o campo senha "123456" com uma senha válida
Quando clico no botão Cadastrar
Então sou redirecionado para a página inicial do sistema
@cadastro_campos_vazios
 Cenário: Cadastro com campos vazios
    Dado que estou na tela de cadastro de usuário
    Quando clico no botão Cadastrar sem preencher os campos
    Então vejo mensagem de erro indicando que nome deve ser preenchido
@validar_email
  Cenário: Validar formato do e-mail

    Dado que estou na tela de cadastro de usuário
    E preencho o campo nome "Testador" com um nome válido
    E preencho o campo email "teste.com.br" com um formato inválido
    E preencho o campo senha "123456" com uma senha válida
    Quando tento prosseguir com o cadastro
    Então vejo uma mensagem de erro

  @valida_senha
  Cenário: Validar comprimento mínimo da senha

    Dado que estou na tela de cadastro de usuário
    E preencho o campo nome "Testador" com um nome válido
    E preencho o campo "testador@testador.com" com um e-mail válido
    E preencho o campo senha " 123 " com uma senha muito curta
    Quando tento prosseguir com o cadastro
    Então vejo uma mensagem de erro indicando que o campo senha de ter pelo menos 6 dígitos

  