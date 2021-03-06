package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by rosroman on 23/03/17.
 */


public class SearchSteps extends BaseUtil {

    private Base.BaseUtil base;

    public SearchSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to google page$")
    public void iNavigateToGooglePage() throws Throwable {

        //I open browser in here, as it is not working in the Hook
        //Driver = new FirefoxDriver();
        base.Driver.navigate().to("http://www.google.es");
        System.out.println("I navigate to google page\n");
    }

    @And("^I enter \"([^\"]*)\" in field search$")
    public void iEnterInFieldSearch(String searchterm) throws Throwable {


        base.Driver.findElement(By.id("lst-ib")).sendKeys(searchterm);
        System.out.println("The term I want to search is: " + searchterm);


    }

    @And("^I click search button$")
    public void iClickSearchButton() throws Throwable {
        base.Driver.findElement(By.id("lst-ib")).submit();

    }

    @Then("^I should see the results page$")

    public void iShouldSeeTheResultsPage() throws Throwable {
        
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("It's not displayed", base.Driver.findElement(By.id("resultStats")).isDisplayed(), true);


    }
}
