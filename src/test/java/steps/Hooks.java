package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;

public class Hooks {
    Base base;
    
    // construtor
    public Hooks(Base base){;
        this.base = base;
    }

    @Before
    public void iniciar(){
        
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        base.driver.manage().window().maximize();
    }
    @After
    public void finalizar(){
        base.driver.quit();
    }
}

