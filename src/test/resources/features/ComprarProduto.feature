#language: pt

Funcionalidade: Escolher produto e colocar no carrinho de compras 

    Esquema do Cenario: Comprar produto 
        Dado que acessei o site "https://www.saucedemo.com/" 
        E preenchi o usuario com <username> 
        E preenchi a senha com <password> 
        E cliquei no botão de login 
        Quando adicionei o produto <produto> no carrinho 
        Entao o carrinho lista o <produto> escolhido com o preço <preco> 

    Exemplos:
        | username         | password       | produto                   | preco    |
        | "standard_user"  | "secret_sauce" | "Sauce Labs Backpack"     | "$29.99" |
        | "standard_user"  | "secret_sauce" | "Sauce Labs Bolt T-Shirt" | "$15.99" |

       
        








