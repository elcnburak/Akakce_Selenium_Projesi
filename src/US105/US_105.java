package US_105;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_105 extends BaseDriver {
    @Test
    public void test105(){
        driver.get("https://www.akakce.com/");
        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/"));


        WebElement loggin= driver.findElement(By.xpath("//*[@id='H_rl_v8']/a[2]"));
        loggin.click();


        WebElement email= driver.findElement(By.xpath("//*[@id='life']"));
        email.sendKeys("Ahmet_mail@gmail.com");


        WebElement sifre= driver.findElement(By.xpath("//*[@id='lifp']"));
        sifre.sendKeys("Ahmet123@");


        WebElement submit= driver.findElement(By.xpath("//*[@id='lfb']"));
        submit.click();



        WebElement ahmet= driver.findElement(By.xpath("//*[@id='HM_v8']"));
        Actions aksiyonDriver=new Actions(driver);
        Action aksiyon=aksiyonDriver.moveToElement(ahmet).build();// element in üzerine gel
        aksiyon.perform();// etki oluştur(mouse üzerinde).
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='HM_v8']")));

        WebElement hesap= driver.findElement(By.xpath("//*[text()='Hesabım']"));
        hesap.click();

        WebElement siparis= driver.findElement(By.xpath("//*[text()='Siparişlerim']"));
        siparis.click();

        WebElement siparisStatus= driver.findElement(By.xpath("//*[text()='Kayıtlı siparişiniz bulunmuyor.']"));

        Assert.assertTrue("Siparis listede yanlis verdi", siparisStatus.getText().contains("Kayıtlı siparişiniz bulunmuyor.") );








    }
}
