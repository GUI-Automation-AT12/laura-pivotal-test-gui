package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//button[@aria-label='Profile Dropdown']")
    private WebElement profileDropDown;

    /**
     * Instantiates a new Home page.
     *
     * @param driver the driver
     * @param wait   the wait
     */
    public HomePage(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Gets profile drop down.
     *
     * @return the profile drop down
     */
    public WebElement getProfileDropDown() {
        return profileDropDown;
    }

    /**
     * Sets profile drop down.
     *
     * @param profileDropDown the profile drop down
     */
    public void setProfileDropDown(final WebElement profileDropDown) {
        this.profileDropDown = profileDropDown;
    }
}
