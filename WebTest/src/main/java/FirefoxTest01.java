import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.internal.seleniumemulation.GetText;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest01 {
    public static void main(String[] args) throws IOException {
        // 设置 chrome 的路径
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\chromedriver\\chromedriver.exe");
        // 创建一个 ChromeDriver 的接口，用于连接 Chrome
        // 创建一个 Chrome 的浏览器实例
        WebDriver driver = new ChromeDriver();
        Navigation navigation=driver.navigate();
        navigation.to("http://www.baidu.com");
        WebElement webElement=driver.findElement(By.id("kw"));
        webElement.sendKeys("crying the poodles");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement webElement1=driver.findElement(By.linkText("新闻"));
        webElement1.click();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        navigation.to("http://www.taobao.com");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        navigation.back();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        navigation.forward();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        navigation.refresh();
        String url=driver.getCurrentUrl();
        System.out.println(url);

        /*// 让浏览器访问 Baidu
        driver.get("http://www.baidu.com");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.baidu.com");

        // 获取 网页的 title
        System.out.println("1 Page title is: " + driver.getTitle());

        // 通过 id 找到 input 的 DOM
        WebElement element = driver.findElement(By.id("kw"));

        // 输入关键字
        element.sendKeys("zTree");

        // 提交 input 所在的 form
        element.submit();

        // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().endsWith("ztree");
            }
        });*/

        navigation.to("http://tieba.baidu.com/f/search/adv");
        WebElement webElement2=driver.findElement(By.name("sm"));
        String targerText="按相关性排序";
        List<WebElement> options=webElement2.findElements(By.tagName("option"));
        for(int i=0;i<options.size();i++){
            if(options.get(i).getText().equals(targerText)){
                options.get(i).click();
            }
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement webElement6=driver.findElement(By.xpath("//*[@id=\"com_userbar\"]/ul/li[4]/div/a"));
        webElement6.click();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement webElement7=driver.findElement(By.id("TANGRAM__PSP_8__memberPass"));
        boolean isSelect=webElement7.isSelected();
        System.out.println("是否勾选："+isSelect);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        navigation.to("http://10.125.24.154:7077/v550/webeditor/app/road-editor/index.html?env=8#");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement webElement5=driver.findElement(By.xpath("//*[@id=\"user\"]/h3"));
        System.out.println(webElement5.getText());
        /**
         * 输入用户名、密码
         */
        WebElement webElement3=driver.findElement(By.xpath("//*[@id=\"user\"]/form/input[1]"));
        webElement3.sendKeys("cli_my");
        WebElement webElement4=driver.findElement(By.xpath("//*[@id=\"user\"]/form/input[2]"));
        webElement4.sendKeys("1234567");
        webElement4.submit();
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 显示搜索结果页面的 title
        System.out.println("title is: " + driver.getTitle());

        // 关闭浏览器
        driver.quit();
        // 关闭 ChromeDriver 接口
    }
}