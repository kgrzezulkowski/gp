package bddTest;

import GP.BettingLocators;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.After;
import org.openqa.selenium.Dimension;

@Config(
        browser = Browser.CHROME
)

public class bettingBdd extends Locomotive {
    String url = "http://sports.williamhill.com/betting/en-gb";

    @After
    public void clean() {
        driver.quit();
    }

    @Given("The user is on betting page")
    public void The_user_is_on_betting_page() throws Throwable {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Given("^The mobile user is on betting page$")
    public void theMobileUserIsOnBettingPage() throws Throwable {
        driver.manage().window().setSize(new Dimension(411, 731)); // I've chosen the regular Nexus mobile browser dimension
        driver.get(url);
        waitForElement(BettingLocators.MobileOverlayHidden); // Here I'm waiting until the mobile page is ready - when the overlay disappears
        waitForElement(BettingLocators.MobileBetSlipBox); // Double check if the Bet slip feature is ready (at least shown for the user)
    }

    @When("^Click on home button for \"([^\"]*)\"$")
    public void clickOnHomeButtonFor(String team) throws Throwable {
        waitForElement(BettingLocators.TeamXPath(team));
        click(BettingLocators.TeamXPath(team));
        waitForElement(BettingLocators.TeamXpathActive(team)); // It's waiting here for the button to be active
    }

    @Then("^BetSlipBox for \"([^\"]*)\" should be displayed$")
    public void betslipboxForShouldBeDisplayed(String team) throws Throwable {
        waitForElement(BettingLocators.BetSlipBox);
        validateText(BettingLocators.BetSlipBox,team);
    }

    @When("^Set \"([^\"]*)\" as bet input$")
    public void setAsInput(String bet) throws Throwable {
        waitForElement(BettingLocators.BetSlipInput);
        setText(BettingLocators.BetSlipInput, bet);
    }

    @When("^Click Place Bet button$")
    public void clickPlaceBetButton() throws Throwable {
        click(BettingLocators.PlaceBetButton);
    }

    @Then("^Stacked price is \"([^\"]*)\"$")
    public void stackedPriceIs(String stackedPrice) throws Throwable {
        validateText(BettingLocators.BetSlipStakedPrice, stackedPrice);
    }

    @Then("^Odds are \"([^\"]*)\"$")
    public void oddsAre(String odds) throws Throwable {
        validateText(BettingLocators.BetSlipOdds, odds);
    }

    @When("^Click on MobileBetSlipIcon$")
    public void clickOnMobileBetSliIcon() throws Throwable {
        click(BettingLocators.MobileBetSlipBox);
    }
}
