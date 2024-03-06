package US102;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TC_0102 extends BaseDriver {

    @Test
    public void TC_0102() {

        driver.get("https://www.akakce.com");
        MyFunc.Bekle(2);

        WebElement girisYap= driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[1]"));
        girisYap.click();

        WebElement doldurEposta= driver.findElement(By.xpath("//*[@id=\"life\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        doldurEposta.sendKeys("testmest2014@gmail.com");

        WebElement doldurSifre= driver.findElement(By.xpath("//*[@id=\"lifp\"]"));
        doldurSifre.sendKeys("Testmest123");

        WebElement girisYap2= driver.findElement(By.xpath("//*[@id=\"lfb\"]"));
        girisYap2.click();

        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/"));
        WebElement checkName= driver.findElement(By.xpath("(//*[text()='Test'])"));
        Assert.assertTrue("kullanıcı doğrulama yanlış", checkName.getText().equals("Test"));



        BekleKapat();


    }
}