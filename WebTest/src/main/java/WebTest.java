/**
 * Created by renjun.lrj on 2017/1/1.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.baidu.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test111() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("selenium");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("百度一下".equals(driver.findElement(By.id("su")).getAttribute("value"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("su")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("新闻".equals(driver.findElement(By.cssSelector("#s_tab > a")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("#s_tab > a"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#s_tab > a")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/a[1]")).click();
        Thread.sleep(1000);
        // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //div[3]/div[2]/a[1] | ]]
        String suvalue = driver.findElement(By.id("su")).getAttribute("value");
        System.out.println(suvalue);
        // ERROR: Caught exception [ERROR: Unsupported command [isTextPresent | 贴吧 | ]]
        //System.out.println(exist);
        // ERROR: Caught exception [unknown command []]
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
