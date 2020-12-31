package core.selenium.factory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    public WebDriver initDriver() {

        //ChromeDriverManager.getInstance().version("76.0.3809.126").setup();
        ChromeDriverManager.getInstance(ChromeDriver.class).setup();
       // WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
