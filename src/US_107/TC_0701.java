package US_107;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class TC_0701 extends BaseDriver {
    //1. Kullanıcı Akakce.com sitesini tarayıcıda açar.
    //2. Kullanıcı ana sayfada "Giriş Yap" veya benzer bir seçeneği bulur
    //ve tıklar.
    //3. Kullanıcı, test data daki geçerli bilgileri girer:
    //4. "Giriş Yap" butonuna tıklar.
    //5. Kullanıcı hesabına başarılı bir şekilde giriş yapar.
    //6. Kullanıcı, hesap ayarları veya profil bölümünden "Hesabımı Sil"
    //veya benzer bir seçeneğe tıklar.
    //7. Hesap silme işlemi başarılı bir şekilde tamamlandığında, uygun
    //bir mesajın görüntülendiğini kontrol eder.


    //1. Kullanıcı Akakce.com sitesini tarayıcıda açar.

    public void TC_0701_1() {

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

        //6. Kullanıcı, hesap ayarları veya profil bölümünden "Hesabımı Sil"
        //veya benzer bir seçeneğe tıklar.

        Actions driverAksiyon=new Actions(driver);
        WebElement icon=driver.findElement(By.xpath("//*[@id=\"H_a_v8\"]"));
        WebElement Hesabim=driver.findElement(By.xpath("//*[@id=\"HM_v8\"]/ul/li[5]/a"));

        driverAksiyon.moveToElement(icon).build().perform();
        System.out.println("Aksiyon hazırlandı");
        driverAksiyon.click(Hesabim).build().perform();

        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/"));
        WebElement silTikla= driver.findElement(By.xpath("//*[text()='Hesabımı Sil']"));
        silTikla.click();

        //7. Hesap silme işlemi başarılı bir şekilde tamamlandığında, uygun
        //bir mesajın görüntülendiğini kontrol eder.
        WebElement passDoldur= driver.findElement(By.xpath("//*[@id=\"p\"]"));
        wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Hesabımı Sil"));
        passDoldur.sendKeys("2524524");
        WebElement click2= driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        click2.click();
        MyFunc.Bekle(4);

//alert açıldı
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement msg=driver.findElement(By.xpath("//*[@id=\"info\"]"));
        Assert.assertTrue("Şifre yanlış mesajı bulunamadı!", msg.getText().contains("Şifreyi kontrol ediniz."));

        BekleKapat();

}}
