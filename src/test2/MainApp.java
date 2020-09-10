package test2;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.net.URL;

public class MainApp {
    public static void main(String[] args) {

        //Отправка запроса с параметрами JSON
        System.out.println("JSON");
        try {
            URL jsonURL = new URL("https://status.encoding.com/status.php?format=json");
            ObjectMapper objectMapper = new ObjectMapper();

            TestObj testObjJson = objectMapper.readValue(jsonURL, TestObj.class);
            TestObj.trueFalse(testObjJson);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //Отправка запроса с параметрами XML
        System.out.println("XML");
        try {
            URL xmlURL = new URL("https://status.encoding.com/status.php?format=xml");

            TestObj testObjXml = JAXB.unmarshal(xmlURL, TestObj.class);
            TestObj.trueFalse(testObjXml);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
