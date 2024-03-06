package US_106;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utility.BaseDriver.driver;

public class TC_0601 extends BaseDriver {

    //1. Kullanıcı Akakce.com sitesini tarayıcıda açar.
    //2. Kullanıcı ana sayfada "Giriş Yap" veya benzer bir seçeneği bulur
    //ve tıklar.
    //3. Kullanıcı, test dataki geçerli bilgileri girer.
    //4. "Giriş Yap" butonuna tıklar.
    //5. Kullanıcı hesabına başarılı bir şekilde giriş yapar.
    //6. Kullanıcı sağ üst köşede bulunan account kısmından "Hesabım"
    //linkine tıklayarak profil sayfasına ulaşır
    //7. Kullanıcı profil sayfasında Mesajlarım linkine tıklayarak mesaj
    //kutusuna yönlendirilir.
    //8. Eğer mesaj kutusu boşsa, uygun bir mesajın görüntülendiğini
    //kontrol eder.
@Test
    public void TC_0601_1() {
    //1. Kullanıcı Akakce.com sitesini tarayıcıda açar.

            driver.get("https://www.akakce.com/");
            MyFunc.Bekle(2);

        //2. Kullanıcı ana sayfada "Giriş Yap" veya benzer bir seçeneği bulur ve tıklar
        WebElement girisYap= driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[1]"));
        girisYap.click();

        //3. Kullanıcı, test dataki geçerli bilgileri girer.
        WebElement doldurEposta= driver.findElement(By.xpath("//*[@id=\"life\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        doldurEposta.sendKeys("testmest2014@gmail.com");

        WebElement doldurSifre= driver.findElement(By.xpath("//*[@id=\"lifp\"]"));
        doldurSifre.sendKeys("Testmest123");

        //4. "Giriş Yap" butonuna tıklar.

        WebElement girisYap2= driver.findElement(By.xpath("//*[@id=\"lfb\"]"));
        girisYap2.click();

        //5. Kullanıcı hesabına başarılı bir şekilde giriş yapar.
        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/"));

        //6. Kullanıcı sağ üst köşede bulunan account kısmından "Hesabım"
        //linkine tıklayarak profil sayfasına ulaşır

        Actions driverAksiyon=new Actions(driver);
        WebElement icon=driver.findElement(By.xpath("//*[@id=\"H_a_v8\"]"));
        WebElement Hesabim=driver.findElement(By.xpath("//*[@id=\"HM_v8\"]/ul/li[5]/a"));

        driverAksiyon.moveToElement(icon).build().perform();
        System.out.println("Aksiyon hazırlandı");
        driverAksiyon.click(Hesabim).build().perform();

        //7. Kullanıcı profil sayfasında Mesajlarım linkine tıklayarak mesaj
        //kutusuna yönlendirilir.
    wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/"));
    WebElement mesajTikla= driver.findElement(By.xpath("//*[text()='Mesajlarım']"));
        mesajTikla.click();

        //8. Eğer mesaj kutusu boşsa, uygun bir mesajın görüntülendiğini
        //kontrol eder.
        WebElement msg=driver.findElement(By.xpath("//*[@id=\"C4w\"]/div/p"));
        Assert.assertTrue("Aranılan mesaj bulunamadı!", msg.getText().contains("Listelenecek mesaj bulunamadı."));

        BekleKapat();



    }
}
