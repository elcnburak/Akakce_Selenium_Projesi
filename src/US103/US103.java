package US103;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US103 extends BaseDriver {

    @Test
    public void US103(){

        driver.get("https://www.akakce.com/akakcem/giris/");
        MyFunc.Bekle(2);

        WebElement eposta= driver.findElement(By.xpath("//input[@id='life']"));
        eposta.sendKeys("testmest2014@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@id='lifp']"));
        password.sendKeys("Testmest123");

        WebElement enterButon=driver.findElement(By.xpath("//input[@id='lfb']"));
        enterButon.click();

        List<WebElement> consent=driver.findElements(By.xpath("//*[text()='Tümünü Kabul Et']"));
        if(consent.size()>0)
            consent.get(0).click();

        WebElement hesapSimge= driver.findElement(By.xpath("//a[@id='H_a_v8']"));
        hesapSimge.click();

        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(5));
        bekle.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Çık']")));

        WebElement cikis=driver.findElement(By.xpath("//a[text()='Çık']"));
        cikis.click();


        Assert.assertTrue("Anasayfa URL bulanamadı",driver.getCurrentUrl().equals("https://www.akakce.com/"));

        BekleKapat();

    }
}
