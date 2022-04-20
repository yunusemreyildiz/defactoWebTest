package pages;

import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import java.time.Duration;

public class BasketPage extends TestBase {

    private static Logger log  = Logger.getLogger(BasketPage.class);

    public static void checkTheBasketPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        AssertJUnit.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ContainerShoppingCart\"]/div[1]"))).getText(),"Sepetim (1 Ürün)");
        log.info(driver.findElement(By.xpath("//*[@id=\"ContainerShoppingCart\"]/div[1]")).getText() + " page is loaded succesfully..");
    }

    public static void deleteProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ContainerShoppingCart > div.row > div.col-lg-9.col-md-8.col-sm-12 > div.shopping-left > div > div > div.shopping-product-card > div.shopping-product-card__info > div.shopping-product-card__info--controls > div.control-buttons > a.product-delete-item.mr-2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"productDeleteModal\"]/div/div[2]/div[2]/button[2]"))).click();
        log.info("The product deleted");
    }

    public static void isProductDeleted() throws InterruptedException {
        Thread.sleep(4000);
        if (driver.findElement(By.xpath("//*[@id=\"ContainerShoppingCartEmpty\"]/div/div[2]")).getText().equals("Sepetinizde ürün yok.")){
            log.info("The product deleted." + " Test ended succesfully.");
        }
        else {
            log.fatal("The product could not deleted!" + " Error while deleting product.");
        }
    }

}
