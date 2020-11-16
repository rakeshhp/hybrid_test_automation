package pageObjects;
import core.BaseSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage {
   static final WebDriver driver = BaseSetup.driver;

    @FindBy(xpath="//input[@title=\"Search\"]")
    private WebElement searchInpt;

    @FindBy(id ="hplogo" )
    private WebElement logoTxt;

    public searchPage(){
        PageFactory.initElements(driver, this);
    }

    public String pageTitle(){
        return driver.getTitle();
    }

    public void enterSearchInput(String text){
        searchInpt.click();
        searchInpt.sendKeys(text);

    }

    public void sendEnterKey(){
       searchInpt.sendKeys(Keys.ENTER);
    }

}
