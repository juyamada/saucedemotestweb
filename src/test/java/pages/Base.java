package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
    public WebDriver driver;

    public void iniciarDriver(){

        System.setProperty("webdriver.chrome.driver", "C:/Iterasys/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Inicia o navegador maximizado

        // Inicializa o WebDriver com as opções configuradas
        driver = new ChromeDriver(options);
    }

    public void encerrarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
    

