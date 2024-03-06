package US_104;

import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_104 extends BaseDriver {
        @Test
        public void test104() {
            driver.get("https://www.akakce.com/");
            wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/"));


            WebElement loggin = driver.findElement(By.xpath("//[@id='H_rl_v8']/a[2]"));
            loggin.click();


            WebElement email = driver.findElement(By.xpath("//[@id='life']"));
            email.sendKeys("Ahmet_mail@gmail.com");


            WebElement sifre = driver.findElement(By.xpath("//[@id='lifp']"));
            sifre.sendKeys("Ahmet123@");


            WebElement submit = driver.findElement(By.xpath("//[@id='lfb']"));
            submit.click();


        }
    }





