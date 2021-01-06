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

    /**
     * Instantiates a new Story component.
     */
    public StoryComponent() {
        super();
    }

    /**
     * Gets text from story title.
     *
     * @return the text from story title
     */
    public String getTextFromStoryTitle() {
        return WebElementInteractor.getTxt(storyTitle);
    }

    /**
     * Gets text numbers from attribute value of story id.
     *
     * @return the text numbers from attribute value of story id
     */
    public String getTextNumbersFromAttributeValueOfStoryId() {
        return WebElementInteractor.getAttributeValue(storyId).substring(1);
    }
}
