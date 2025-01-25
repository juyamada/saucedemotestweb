package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonPage{

    //contrustor
    public CheckoutPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //mapear elementos
    @FindBy(css = "span[data-test='title']")
    WebElement cartTitle;

    @FindBy(css = "div[data-test='inventory-item-name']")
    WebElement productName;

    @FindBy(css = "div[data-test='inventory-item-price']")
    WebElement productPrice;
    
    //ações dos elementos
    // criar métodos getter para conseguir acessar os elements sem ter que torná-los públicos
    public String getCartTitle(){
        return cartTitle.getText();
    }
    public String getProductName(){
        return productName.getText();
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
}
