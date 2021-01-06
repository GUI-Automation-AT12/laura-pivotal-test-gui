package pivotal.ui.components;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.BasePage;

public class StoryComponent extends BasePage {

    @FindBy(css = "textarea[aria-label='story title']")
    private WebElement storyTitle;

    @FindBy(css = "div.button_with_field input")
    private WebElement storyId;

    public StoryComponent() {
        super();
    }

    public String getTextFromStoryTitle() {
        return WebElementInteractor.getTxt(storyTitle);
    }

    public String getTextNumbersFromAttributeValueOfStoryId() {
        return WebElementInteractor.getAttributeValue(storyId).substring(1);
    }
}
