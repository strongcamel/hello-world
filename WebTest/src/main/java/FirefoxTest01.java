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
        // ���� chrome ��·��
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\chromedriver\\chromedriver.exe");
        // ����һ�� ChromeDriver �Ľӿڣ��������� Chrome
        // ����һ�� Chrome �������ʵ��
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
        WebElement webElement1=driver.findElement(By.linkText("����"));
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

        /*// ����������� Baidu
        driver.get("http://www.baidu.com");
        // ���������Ҳ����ʵ��
        // driver.navigate().to("http://www.baidu.com");

        // ��ȡ ��ҳ�� title
        System.out.println("1 Page title is: " + driver.getTitle());

        // ͨ�� id �ҵ� input �� DOM
        WebElement element = driver.findElement(By.id("kw"));

        // ����ؼ���
        element.sendKeys("zTree");

        // �ύ input ���ڵ� form
        element.submit();

        // ͨ���ж� title ���ݵȴ�����ҳ�������ϣ�Timeout ����10��
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().endsWith("ztree");
            }
        });*/

        navigation.to("http://tieba.baidu.com/f/search/adv");
        WebElement webElement2=driver.findElement(By.name("sm"));
        String targerText="�����������";
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
        System.out.println("�Ƿ�ѡ��"+isSelect);
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
         * �����û���������
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
        // ��ʾ�������ҳ��� title
        System.out.println("title is: " + driver.getTitle());

        // �ر������
        driver.quit();
        // �ر� ChromeDriver �ӿ�
    }
}