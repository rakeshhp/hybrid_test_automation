package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.searchPage;

public class CommonDefinitions {
    searchPage googleSearch = new searchPage();

    @Given("User is on Google search engine page")
    public void user_on_google_search_page() throws Throwable {
      Assert.assertEquals(googleSearch.pageTitle(), "Google");
    }
    @When("User enters search text as {string}")
    public void user_enters_search_text(String searchText)throws Throwable {
        googleSearch.enterSearchInput(searchText);
    }

    @And("press the key enter to search")
    public void enter_key_to_search() throws Throwable {
        googleSearch.sendEnterKey();

    }
    @Then("google result page title should be {string}")
    public void result_page_title_should_be(String searchTitle)throws Throwable {
        Assert.assertEquals(googleSearch.pageTitle(), searchTitle);
    }

}

