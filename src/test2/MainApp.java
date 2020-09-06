package test2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class MainApp {
    public static void main(String[] args) {
        try {
            URL jsonURL = new URL("https://status.encoding.com/status.php?format=json");
            ObjectMapper objectMapper = new ObjectMapper();

            TestObj testObj = objectMapper.readValue(jsonURL, TestObj.class);
            TestObj.trueFalse(testObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
