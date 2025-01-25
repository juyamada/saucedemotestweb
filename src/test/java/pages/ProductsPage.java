package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends CommonPage{
    // contrutor
    public ProductsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // mapear elementos

    @FindBy (css = "a[data-test='shopping_cart_link']")
    WebElement cartIcon;


    // ação dos elementos

    public void adicionarProdutoCarrinho(String productName){
        String cssSelector = String.format("button[id='add-to-cart-%s']", productName); //forma dinamica de selecionar produtos diferentes de acordo com os proddutos registrados na feature
        driver.findElement(By.cssSelector(cssSelector)).click();

    }    
    public void clicarCarrinho(){
        cartIcon.click();
    }
    
}
