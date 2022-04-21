package pages;

import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import java.time.Duration;

public class CategoryPage extends TestBase {

    public static void checkTheCategoryPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        AssertJUnit.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > main > div > div:nth-child(1) > div > h1"))).getText(),"Kadın Blazer Ceket");
        log.info(driver.findElement(By.cssSelector("body > main > div > div:nth-child(1) > div > h1")).getText() + " selection loaded successfully.");
    }

    public static void clickSizeFromLeftMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"catalog-filter__nav\"]/ul/li[3]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            if (driver.findElement(By.xpath("//*[@id=\"catalog-filter__nav\"]/ul/li[2]/ul/li[2]/ul/li[1]")).getText().equals("S")){
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"catalog-filter__nav\"]/ul/li[2]/ul/li[2]/ul/li[1]"))).click();
                log.info(driver.findElement(By.xpath("//*[@id=\"catalog-filter__nav\"]/ul/li[2]/ul/li[2]/ul/li[1]")).getText() + " products loaded successfully.");
            }
            else{
                log.fatal("Products could not load.");
            }
    }

    public static void clickToProduct() throws InterruptedException {
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-fill\"]/div/div[1]"))).click();
        log.info("Clicked on product.");
    }

}
