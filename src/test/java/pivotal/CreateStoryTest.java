package pivotal;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CreateStoryTest {
  private WebDriver driver;
  private WebDriverWait wait;
  //private Environment environment;
  @Test
  public void test() throws InterruptedException {
    try{
      System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://selenium.dev");
     // driver.navigate().to("https://www.codota.com/code/java/classes/org.openqa.selenium.JavascriptExecutor");
     // driver.navigate().refresh();
     // String currentUrl = driver.getCurrentUrl();
   //   String title = driver.getTitle();
      String originalWindow = driver.getWindowHandle();
      assert driver.getWindowHandles().size() == 1;
      driver.findElement(By.linkText("new window")).click();
    //  driver.findElement(withTagName())
      wait.until(numberOfWindowsToBe(2));
      for(String windowHandle : driver.getWindowHandles()) {
        if (!originalWindow.contentEquals(windowHandle)) {
          driver.switchTo().window(windowHandle);
          break;
        }
      }
      wait.until(titleIs("Selenium documentation"));
      //System.out.println("****Aux:" + aux);
//      driver.navigate().back();
//      driver.navigate().forward();
    } finally {
      driver.quit();
    }
  }



 /* @Before
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver","D:\\AT\\GUI Automation\\code\\pivotal\\src\\test\\resources\\chromedriver_win32\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
    driver = new ChromeDriver();
    environment.authenticateUsing(e5dbe8a15be98b7d38a535aaad0d6fdc);

  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void createStoryTest() {
    driver.get("https://www.pivotaltracker.com/dashboard");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.linkText("demo")).click();
    // driver.findElement(By.cssSelector(".projectTileHeader__projectName")).click();
    driver.findElement(By.cssSelector(".tn-PanelHeader__action___3zvuQp6Z:nth-child(3) .MuiButton-label")).click();
    driver.findElement(By.name("story[name]")).sendKeys("demo");
    driver.findElement(By.id("story_close_c201")).click();
    assertThat(driver.findElement(By.cssSelector(".story_name")).getText(), is("demo"));
  }*/
}
