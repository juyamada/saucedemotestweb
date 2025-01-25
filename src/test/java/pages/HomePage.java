package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonPage{

    // construtor
    public HomePage(WebDriver driver){
        super(driver); // driver herdado de CommonPage - super classe
        PageFactory.initElements(driver,this);
    }

    // elementos mapeados
    // mapeamento dos campos de login

    @FindBy(id = "user-name")
    WebElement campoUsername;

    @FindBy(id = "password")
    WebElement campoPassword;
    
    @FindBy(id = "login-button")
    WebElement botaoLogin;
    

    // ações com os elementos mapeados
    public void acessarHomePage(String url){
        driver.get(url);
    }
    public String lerNomeDaGuia(){
        return driver.getTitle();
    }

    public void preencherUsername(String username){
        campoUsername.sendKeys(username);
    }
    public void preencherPassword(String password){
       
        campoPassword.sendKeys(password);
    }
    public void clicarBotaoLogin(){
        botaoLogin.click();
    }
    
}


