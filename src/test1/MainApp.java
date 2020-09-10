package test1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\stc projects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://api.encoding.com/";

        driver.get(baseUrl);

        driver.findElement(By.xpath("//button[contains(@class, 'searchbox-input')]")).click();

        WebElement searchPanel = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        searchPanel.click();

        searchPanel.sendKeys("getStatus");

        driver.findElement(By.xpath("//header[contains(@title, 'GetStatus (extended)')]")).click();

        driver.get("https://api.encoding.com/reference#responses-getstatus-extended");

        //проверка текущего URL
        String currentUrl = "https://api.encoding.com/reference#responses-getstatus-extended";
        if (currentUrl.equals(driver.getCurrentUrl())) {
            System.out.println(driver.getCurrentUrl() + " URLs matched! True!");
        } else {
            System.out.println(driver.getCurrentUrl() + " URLs didn't match! False!");
        }

        driver.findElement(
                By.xpath("//div[@id=\"page-responses-getstatus-extended\"]/descendant::button[contains(text(),\"JSON\")][2]"))
                .click();
        String jsonStr = driver.findElement(By.xpath("//*[@id=\"page-responses-getstatus-extended\"]/descendant::code[@data-lang=\"json\"][2]")).getText();
        driver.close();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            EncodingObj result = objectMapper.readValue(jsonStr, EncodingObj.class);

            //проверка параметра 'processor'
            System.out.printf("Параметр 'processor' содержит значения %s: %s%n",
                    result.response.jobs[0].processor,
                    isEquals(result.response.jobs[0].processor));

            //проверка параметра 'status' на уровне 'format'
            System.out.printf("На уровне 'format' параметр 'status' равен %s: %s%n",
                    result.response.jobs[0].formats[0].status,
                    isEquals(result.response.jobs[0].formats[0].status));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * проверяет эквивалентны ли значения с задданными
     * @param value processor or format-status
     * @return boolean true-test passed or false-test failed
     */
    public static boolean isEquals(String value){
        try {
            if ("[AMAZON | RACKSPACE]".equals(value)){
                return true;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            if ("[Status]".equals(value)) {
                return true;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
