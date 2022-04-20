package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends TestBase {

    private static Logger log  = Logger.getLogger(HomePage.class);


    public static void cursorToHoverMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("kadın")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.name("kadın"))).perform();
        log.info("Done, Mouse hover on 'Kadın' from Menu");
    }

    public static void clickSubCategoryfromMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Blazer Ceket"))).click();
        log.info("Clicked Blazer Ceket");
    }

    public static void clickFlyBasketButton(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flycartBtn"))).click();
            log.info("Clicked on Flycart icon.");

    }

    public static void clickGoToBasketButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#section__cart > div.sideMenu__footer.fly-cart__sticky.fly-cart__sticky--bottom > div > button.button.button--fluid.button--border.fly-cart__go-to-cart--button"))).click();
        log.info("Clicked on 'Go to Basket' button.");

    }

}