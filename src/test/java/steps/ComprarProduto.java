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


public class ComprarProduto {
    WebDriver driver;  //objeto do selenium webdriver
    String produto;
    String preco;

    @Before
    public void iniciar(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }
    

    @Dado("que acessei o site {string}")
    public void que_acessei_o_site(String url) {
        driver.get(url);
    }
    
    @E("preenchi o username com {string}")
    public void preenchi_o_username_com_standard_user(String username) {
        {
            WebElement usuario = driver.findElement(By.id("user-name"));
            usuario.click();
            usuario.sendKeys(username);
        }
    }

    @E("preenchi o password com {string}")
    public void preenchi_o_password_com(String password) {
        {
            WebElement senha = driver.findElement(By.id("password"));
            senha.click();
            senha.sendKeys(password);
            driver.findElement(By.id("login-button")).click();
        }
    
    }

    @Quando("adicionei o produto {string} no carrinho")
    public void adicionei_o_produto_no_carrinho(String produtoNome) {
       
        String produtoId= "";

        if (produtoNome.equals ("Sauce Labs Backpack")){
            produtoId = "add-to-cart-sauce-labs-backpack";
        } else if (produtoNome.equals ("Sauce Labs Bolt T-Shirt")){
            produtoId = "add-to-cart-sauce-labs-bolt-t-shirt";
        }
        
        driver.findElement(By.id(produtoId)).click();
    
    }

    @Entao("o carrinho lista o {string} escolhido com o preço {string}")
    public void o_carrinho_lista_o_escolhido_com_o_preço(String produtoEsperado, String precoEsperado) {
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
        
        String nomeProduto = driver.findElement(By.className("inventory_item_name")).getText();
        assertEquals(produtoEsperado, nomeProduto);

        String precoProduto = driver.findElement(By.className(("inventory_item_price"))).getText();
        assertEquals(precoEsperado, precoProduto);
    }
}
