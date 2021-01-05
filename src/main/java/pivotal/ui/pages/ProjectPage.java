package pivotal.ui.pages;

import core.utils.WebElementInteractor;
import org.openqa.selenium.By;

public class ProjectPage extends BasePage{

    private void waitDashboard() {
        WebElementInteractor.wait(By.id("tracker"));
    }

    /**
     * Is panel Backlog visible boolean.
     *
     * @return true if Panel Backlog is visible, false otherwise
     */
    public boolean isPanelBacklogVisible() {
        waitDashboard();
        return WebElementInteractor.findElement(By.cssSelector("div[data-type='backlog']"));
    }
}
