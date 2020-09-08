package test1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
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
        System.out.println(driver.getCurrentUrl());
        String currentUrl = "https://api.encoding.com/reference#responses-getstatus-extended";
        if (currentUrl.equals(driver.getCurrentUrl())) {
            System.out.println(driver.getCurrentUrl() + " URLs matched! Passed!");
        } else {
            System.out.println(driver.getCurrentUrl() + " URLs didn't match! Fail!");
        }

        driver.findElement(
                By.xpath("//div[@id=\"page-responses-getstatus-extended\"]/descendant::button[contains(text(),\"JSON\")][2]"))
                .click();
        String jsonStr = driver.findElement(By.xpath("//*[@id=\"page-responses-getstatus-extended\"]/descendant::code[@data-lang=\"json\"][2]")).getText();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            //EncodingObj encodingObj = objectMapper.readValue(jsonStr, EncodingObj.class);
            //System.out.println(encodingObj.response);
            HashMap result = new ObjectMapper().readValue(jsonStr, HashMap.class);
            System.out.println(result.toString());
                System.out.println(result.containsKey("processor"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
