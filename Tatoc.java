import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Tatoc {

    public static void main(String a[]) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kunikasaraswat\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://10.0.1.86/tatoc");

        driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();


        driver.findElement(By.className("greenbox")).click();

        driver.switchTo().frame("main");

        String actualColor = driver.findElement(By.id("answer")).getAttribute("class");
        //System.out.println(actualAnswer);

        Boolean condition = true;
        while (condition) {
            driver.findElement(By.xpath("/html/body/center/a[1]")).click();

            WebElement childDiv = driver.findElement(By.id("child"));

            driver.switchTo().frame("child");

            String expectedColor = driver.findElement(By.id("answer")).getAttribute("class");
            // System.out.println(expectedColor);
            driver.switchTo().parentFrame();
            if (actualColor.equals(expectedColor)) {
                condition = false;
            }

        }
        driver.findElement(By.cssSelector("body > center > a:nth-child(9)")).click();
        driver.switchTo().defaultContent();

        WebElement From = driver.findElement(By.xpath("//*[@id=\"dragbox\"]"));

        WebElement To = driver.findElement(By.xpath("//*[@id=\"dropbox\"]"));

        Actions act = new Actions(driver);

        act.dragAndDrop(From, To).build().perform();
        driver.findElement(By.cssSelector("body > div > div.page > a")).click();
        //Pop Up Case
        driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();

        Set<String> ids = driver.getWindowHandles();//holding all windows id
        Iterator<String> it = ids.iterator();//itterate the windows id
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid); //switch from parent window to any other opening windows By mention their Id
        driver.findElement(By.id("name")).sendKeys("kunika");
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window(parentid);
        driver.findElement(By.linkText("Proceed")).click();


        driver.findElement(By.linkText("Generate Token")).click();
        String Value = driver.findElement(By.id("token")).getText();
        String str = Value.substring(Value.indexOf(":") + 2);
        //System.out.println(str);

        Cookie cookie = new Cookie("Token_Generate", str);
        driver.manage().addCookie(cookie);
        driver.quit();


    }
}
