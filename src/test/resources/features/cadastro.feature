#language: pt

Funcionalidade: Cadastro de usuário

Como um visitante
Quero me cadastrar no sistema
Para ter acesso às funcionalidades restritas

Cenário: Cadastro com sucesso

Dado que estou na tela de cadastro de usuário
E preencho o campo nome "Testador" com um nome válido
E preencho o campo "testador@testador.com" com um e-mail válido
E preencho o campo senha "123456" com uma senha válida
Quando clico no botão Cadastrar
Então sou redirecionado para a página inicial do sistema
