package pivotal.ui.components;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.BasePage;

import static pivotal.constants.StoryIdentifiers.STORY_ID;
import static pivotal.constants.StoryIdentifiers.STORY_NAME;

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
     * Gets text from attribute.
     *
     * @param attribute the attribute
     * @return the text from attribute
     */
    public String getTextFromAttribute(final String attribute) {
        return switch (attribute) {
            case STORY_NAME -> WebElementInteractor.getTxt(storyTitle);
            case STORY_ID -> WebElementInteractor.getAttributeValue(storyId).substring(1);
            default -> "";
        };
    }
}
