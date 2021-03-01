import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Dop {

    @Test
    public void CheckUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver Driver = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        Driver.get("https://next.privat24.ua/mobile");
//        By phonecode = By.xpath(".//button[@data-qa-node='phone-code']");
//        Driver.findElement(phonecode).click();
//        Driver.findElement(By.xpath(".//div[@data-qa-node='phone-code-list']")).click();
//        Driver.findElement(By.xpath(".//input[@class='sc-eqIVtm gFwwav']")).sendKeys("Укр");
//        Driver.findElement(By.xpath(".//button[@data-qa-node='phone-code-option' and @data-qa-value='Україна']")).click();
        Driver.findElement(By.xpath(".//input[@data-qa-node='phone-number']")).sendKeys("634156756");
        Driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).clear();
        Driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).sendKeys("34");
        Driver.findElement(By.xpath(".//input[@data-qa-node='numberdebitSource']")).sendKeys("4552331448138217");
        Driver.findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']")).sendKeys("0524");
        Driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys("111");
        Driver.findElement(By.xpath(".//button[@data-qa-node='submit']")).click();

        By details = By.xpath(".//span[@data-qa-node='details']");
        By card = By.xpath(".//td[@data-qa-node='card']");
        By opname = By.xpath(".//span[@data-qa-node='nameB']");
        By amount = By.xpath(".//span[@data-qa-node='amount']");
//        By currency = By.xpath(".//span[@data-qa-node='currency']");
        Assert.assertEquals("Поповнення телефону. На номер +380634156756", Driver.findElement(details).getText());
        Assert.assertEquals("4552 **** **** 8217", Driver.findElement(card).getText());
        Assert.assertEquals("Lifecell Ukraine", Driver.findElement(opname).getText());
        Assert.assertEquals("34", Driver.findElement(amount).getText());
//        Assert.assertEquals("UAH", Driver.findElement(currency).getText());

    }


}
