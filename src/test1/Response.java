package test1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    @JsonProperty("job")
    public Job[] jobs;

    @Override
    public String toString() {
        return "Response{" +
                "jobs=" + Arrays.toString(jobs) +
                '}';
    }
}
