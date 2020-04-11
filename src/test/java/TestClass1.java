import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass1 {
    WebDriver driver;
    @BeforeMethod
    public void befMet(){
        System.setProperty("webdriver.chrome.driver","C:/webdriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.net/home");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.findElement(By.cssSelector(".dropdown-login")).click();
        driver.findElement(By.xpath("//a [ @class = 'dropdown-item tr'][text() = 'Sign Up']")).click();
        driver.findElement(By.xpath("//input [@name='firstname']")).sendKeys("Adolf");
        driver.findElement(By.xpath("//input [@name='lastname']")).sendKeys("Hitler");
        driver.findElement(By.xpath("//input [@name='phone']")).sendKeys("88005553535");
        driver.findElement(By.xpath("//input [@name='email']")).sendKeys("adolf2250@germany.com");
        driver.findElement(By.xpath("//input [@name='password']")).sendKeys("AdolfHitler228");
        driver.findElement(By.xpath("//input [@name='confirmpassword']")).sendKeys("AdolfHitler228");
        driver.findElement(By.xpath("//button [text() = ' Sign Up']")).click();

        String actual= driver.findElement(By.xpath("//h3 [@class='text-align-left']")).getText();
        Assert.assertEquals(actual,"Hi, Adolf Hitler");
    }
    @Test
    public void test2() throws InterruptedException {
    driver.findElement(By.xpath("//i [@class = 'fab fa-facebook']")).click();
    String actual = driver.findElement(By.xpath("//i [@class='fb_logo img sp_Vgu5hh_52BR sx_445ecd']")).getText();
    Assert.assertEquals(actual,"Facebook");
    Thread.sleep(5000);
    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//a [@data-name='hotels']")).click();
        driver.findElement(By.xpath("//input [@class='select2-input']")).click();
        driver.findElement(By.xpath("//input [@class='select2-input']")).sendKeys("Lviv");
        driver.findElement(By.xpath("//span [@class='select2-match']")).click();
        driver.findElement(By.xpath("//input [@id ='checkin']")).click();
        driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div/div[2]/div[25]")).click();
        driver.findElement((By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div[33]"))).click();
        driver.findElement(By.xpath("//div [@id='hotels']//button [@type='submit']")).click();
        String actual=driver.findElement(By.xpath("//span [text()='lviv']")).getText();
        Assert.assertEquals(actual,"lviv");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
