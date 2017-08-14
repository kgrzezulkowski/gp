package GP;

import org.openqa.selenium.By;

public class BettingLocators {

    //The two following rows build the xpath to make the tests easier to change - the change is made in the feature file only
    public static final By TeamXPath(String team){
        return By.xpath("//button[@data-player='" + team + "']");
    }
    public static final By TeamXpathActive(String team) {return By.xpath("//button[@data-player='" + team + "' and @class[contains(.,'active')]]");}

    public static final By BetSlipBox = By.xpath("//span[@class[contains(.,'betslip-selection__name')]]/label");
    public static final By BetSlipInput = By.xpath("//div[@class[contains(.,'betslip')]]//input[@type='text']");
    public static final By BetSlipOdds = By.xpath("//span[@class='betslip-selection__price']");
    public static final By BetSlipStakedPrice = By.xpath("//div[@id='betslip-footer']//div[@class[contains(.,'total-stake-price')]]");
    public static final By PlaceBetButton = By.xpath("//input[@type='button' and @value = 'Place Bet' and @data-ng-click='placeBet()']");

    public static final By MobileBetSlipBox = By.xpath("//*[@class='toolbar__icon icon-bet-slip']");
    public static final By MobileOverlayHidden = By.xpath("//div[@id='wh-global-overlay' and @class='wh-overlay wh-hide']");
}