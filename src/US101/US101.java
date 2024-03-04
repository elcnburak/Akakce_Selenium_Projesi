package US101;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US101 extends BaseDriver {
    @Test
    public void US101(){
        driver.get("https://www.akakce.com/");
        MyFunc.Bekle(2);

        List<WebElement> consent=driver.findElements(By.xpath("//*[text()='Tümünü Kabul Et']"));
        if(consent.size()>0)
            consent.get(0).click();

        WebElement AccountCreat=driver.findElement(By.xpath("//a[text()='Hesap Aç']"));
        AccountCreat.click();

        WebElement name=driver.findElement(By.xpath("//input[@id='rnufn']"));
        name.sendKeys("TestUser123");

        WebElement surname=driver.findElement(By.xpath("//input[@id='rnufs']"));
        surname.sendKeys("Tester");

        WebElement email= driver.findElement(By.xpath("//input[@id='rnufe1']"));
        email.sendKeys("testuser@example.com");

        WebElement email2= driver.findElement(By.xpath("//input[@id='rnufe2']"));
        email2.sendKeys("testuser@example.com");

        WebElement password= driver.findElement(By.xpath("//input[@id='rnufp1']"));
        password.sendKeys("Password123");

        WebElement password2= driver.findElement(By.xpath("//input[@id='rnufp2']"));
        password2.sendKeys("Password123");

        WebElement gender= driver.findElement(By.xpath("//input[@id='rngf']"));
        gender.click();

        WebElement city=driver.findElement(By.xpath("//select[@id='locpr']"));
        Select select=new Select(city);
        select.selectByValue("59");

        WebElement village=driver.findElement(By.xpath("//select[@id='locds']"));
        Select select1=new Select(village);
        select1.selectByValue("780");

        WebElement day=driver.findElement(By.xpath("//select[@id='bd']"));
        Select select3=new Select(day);
        select3.selectByValue("1");

        WebElement month=driver.findElement(By.xpath("//select[@id='bm']"));
        Select select4=new Select(month);
        select4.selectByValue("1");

        WebElement year=driver.findElement(By.xpath("//select[@id='by']"));
        Select select5=new Select(year);
        select5.selectByValue("1990");

        WebElement agreement= driver.findElement(By.xpath("//input[@id='rnufpca']"));
        agreement.click();

        WebElement agreement2= driver.findElement(By.xpath("//input[@id='rnufnee']"));
        agreement2.click();

        WebElement createAccount=driver.findElement(By.xpath("//input[@id='rfb']"));
        createAccount.click();

        BekleKapat();



    }
}
