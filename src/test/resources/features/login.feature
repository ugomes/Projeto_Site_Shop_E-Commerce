#language: pt

Funcionalidade: Login no sistema

Como um usuário
Quero entrar no sistema
Para acessar minhas funcionalidades
@Login_sucesso
Cenário: Login com sucesso

  Dado que estou na tela de login
  E preencho o campo de email com "testador@testador.com.br" com um e-mail válido
  E preencho o campo de senha com "123456" com uma senha válida
  Quando clico no botão Login
  Então a messagem Login Realizado aparece
@Login_senha_invalida
Cenário: Login com senha inválida
    Dado que estou na tela de login
    Quando não preencho os campos obrigatórios
    Então vejo uma mensagem de erro email inválido e senha inválida
@validar_link_não_tenho_conta
Cenário: Ainda não tem conta
    Dado que estou na tela de login
    Quando clico no link Ainda não tem conta
    Então sou redirecionado para a página de cadastro

