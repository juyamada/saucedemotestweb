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
    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    WebElement addProduct;

    @FindBy (css = "a[data-test='shopping_cart_link']")
    WebElement cartIcon;


    // ação dos elementos

    public void adicionarProdutoCarrinho(String productId){
        driver.findElement(By.id("add-to-cart-" + productId)).click();

    }    
    public void clicarCarrinho(){
        cartIcon.click();
    }
    
}
