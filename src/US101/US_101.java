package US101;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class US_101 extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://www.akakce.com/");
        MyFunc.Bekle(3);

        List<WebElement> girisList = driver.findElements(By.cssSelector("div.banner__accept-button"));
        if (girisList.size() > 0)
            girisList.get(0).click();

        WebElement AccountCreate = driver.findElement(By.xpath("//text()='Giriş Yap'"));
        AccountCreate.click();

        BekleKapat();

    }

}
