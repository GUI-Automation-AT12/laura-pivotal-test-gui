package pivotal.ui.pages;

import core.utils.WebElementInteractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.components.StoryComponent;

public class ProjectPage extends BasePage{

    @FindBy(css = ".backlog div[aria-label='default story']")
    private WebElement defaultStoryItemInBacklog;

    @FindBy(css = ".icebox div[aria-label='default story']")
    private WebElement defaultStoryItemInIcebox;

    @FindBy (css = ".icebox div.end_of_list")
    private WebElement iceboxPanel;

    //Dashboard locator
    private final static String DASHBOARD_ID = "tracker";
    //Backlog locator
    private final static String BACKLOG_CSS = "div[data-type='backlog']";

    private void waitDashboard() {
        WebElementInteractor.wait(By.id(DASHBOARD_ID));
    }

    /**
     * Is panel Backlog visible boolean.
     *
     * @return true if Panel Backlog is visible, false otherwise
     */
    public boolean isPanelBacklogVisible() {
        waitDashboard();
        return WebElementInteractor.isElement(By.cssSelector(BACKLOG_CSS));
    }

    private void moveElement(final WebElement elementToMove, final WebElement finalPosition) {
        WebElementInteractor.dragAndDrop(elementToMove, finalPosition);
    }

    /**
     * Move default story from current iteration backlog panel to icebox panel.
     */
    public void moveDefaultStoryFromCurrentIterationBacklogPanelToIceboxPanel() {
        moveElement(defaultStoryItemInBacklog, iceboxPanel);
        defaultStoryItemInBacklog = null;
    }

    /**
     * Is element in current iteration backlog panel boolean.
     *
     * @param storyId the story id
     * @return the boolean
     */
    public boolean IsElementInCurrentIterationBacklogPanel(final String storyId) {
        //Locator of default story in current Iteration/Backlog Panel
        By by = By.cssSelector(".backlog div[data-id='" + storyId + "']");
        return WebElementInteractor.isElement(by);
    }

    /**
     * Is element in icebox panel boolean.
     *
     * @param storyId the story id
     * @return the boolean
     */
    public boolean IsElementInIceboxPanel(final String storyId) {
        //Locator of default story in Icebox Panel
        By by = By.cssSelector(".icebox div[data-id='" + storyId + "']");
        return WebElementInteractor.isElement(by);
    }

    /**
     * Open default story component.
     *
     * @return the story component
     */
    public StoryComponent openDefaultStory() {
        WebElementInteractor.click(defaultStoryItemInIcebox);
        return new StoryComponent();
    }
}
