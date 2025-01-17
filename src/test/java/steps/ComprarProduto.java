package steps;

import io.cucumber.java.pt.Entao;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProductsPage;
import pages.Base;
import pages.CheckoutPage;


public class ComprarProduto {
    // Atributos
    final WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;

    // Construtor
    public ComprarProduto(Base base){
        this.driver = base.driver;
    }

    String produto;
    String preco;

    //As anotações Before e After ficam no Hooks.java

    @Dado("que acessei o site {string}")
    public void que_acessei_o_site(String url) {
        homePage = new HomePage(driver);
        homePage.acessarHomePage(url);
        assertEquals("Swag Labs", homePage.lerNomeDaGuia());
    }
    
    @E("preenchi o usuario com {string}")
    public void preenchi_o_username_com_standard_user(String username) {
        homePage.preencherUsername(username);
    }

    @E("preenchi a senha com {string}")
    public void preenchi_o_password_com(String password) {
       homePage.preencherPassword(password);
    }
    @E("cliquei no botao de login") 
    public void cliquei_no_botao_de_login(){
        homePage.clicarBotaoLogin();
    }

    @Quando("adicionei o produto {string} no carrinho")
    public void adicionei_o_produto_no_carrinho(String productId) {
       productsPage.adicionarProdutoCarrinho(productId);

    }

    @Entao("o carrinho lista o produto{string} escolhido com o preço {string}")
    public void o_carrinho_lista_o_escolhido_com_o_preço(String produto, String preço) {
       
        productsPage.clicarCarrinho();

        CheckoutPage checkoutPage = new CheckoutPage(driver); //instancia a checkoutPage

        assertEquals("Your Cart", checkoutPage.getCartTitle());
        assertEquals(produto, checkoutPage.getProductName());
        assertEquals(preço,checkoutPage.getProductPrice());
        

    }
}
