package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import Base.BaseUtil;

/**
 * Created by rosroman on 23/03/17.
 */
public class Hook extends Base.BaseUtil{

    private Base.BaseUtil base;

    public Hook(Base.BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {

        System.setProperty("webdriver.firefox.marionette", "/Users/rosroman/geckodriver.exe");
        base.Driver = new FirefoxDriver();
        System.out.println("Open browser");
    }

    @After
    public void TearDownTest()
    {
        base.Driver.quit();
        System.out.println("Closing browser");
    }
}
