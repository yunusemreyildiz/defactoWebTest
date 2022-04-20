package tests;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pages.BasketPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import utils.Constants;


public class BasketTest extends TestBase {

    private static Logger log  = Logger.getLogger(BasketTest.class);

    @Before
    public void setup(){
        setDriver();
        PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES_FILE_PATH);
    }

    @After
    public void teardown(){
        closeDriver();
        log.info("Chromedriver has been finished, test is over.");
    }

    @Given("Navigate to website")
    public void navigate_to_website() {
        navigateToHome();
    }

    @When("Check home page is loaded")
    public void check_home_page_is_loaded() {
       isPageLoaded();
    }
    @When("Get cursor to the Kadın category")
    public void get_cursor_to_the_category() {
        HomePage.cursorToHoverMenu();
    }
    @And("Click Ceket option from hamburger menu")
    public void click_option_from_hamburger_menu() {
        HomePage.clickSubCategoryfromMenu();
    }
    @When("From left side on the page, choose Beden option as S on checkbox")
    public void from_left_side_on_the_page_choose_option_as_on_checkbox() {
        CategoryPage.checkTheCategoryPageLoad();
        CategoryPage.clickSizeFromLeftMenu();
    }

    @When("S option items come, choose a random one and click")
    public void option_items_come_choose_a_random_one_and_click() throws InterruptedException {
        CategoryPage.clickToProduct();
    }
    @When("Item's details come, choose a random size")
    public void item_s_details_come_choose_a_random_size() {
        isPageLoaded();
        ProductPage.checkTheProductPageLoad();
        ProductPage.sizeSelection();
    }
    @When("Click to Sepete Ekle button for add to basket")
    public void click_to_button_for_add_to_basket() {
        ProductPage.addToBasket();
    }
    @When("From right top corner, click on the Sepetim icon")
    public void from_right_top_corner_click_on_the_icon() {
        HomePage.clickFlyBasketButton();
    }
    @When("In the Sepet Özet section, click on the Sepete Git button")
    public void in_the_section_click_on_the_button() {
        HomePage.clickGoToBasketButton();
    }
    @When("Sepetim screen loaded")
    public void screen_loaded() {
        isPageLoaded();
        BasketPage.checkTheBasketPageLoad();
    }
    @When("Delete the item with Sil button")
    public void delete_the_item_with_button() {
        BasketPage.deleteProduct();
    }
    @Then("Check if the item has been deleted")
    public void check_if_the_item_has_been_deleted() throws InterruptedException {
       BasketPage.isProductDeleted();
    }

}
