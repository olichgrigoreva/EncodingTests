package test1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
    public String id;
    public String userid;
    public String sourcefile;
    public String status;
    public String notifyurl;
    public String created;
    public String started;
    public String finished;
    public String prevstatus;
    public String downloaded;
    public String filesize;
    public String processor;
    public String progress;
    public String time_left;
    @JsonProperty("format")
    public Format[] formats;

    @Override
    public String toString() {
        return "Job{" +
                "processor='" + processor + '\'' +
                ", formats=" + Arrays.toString(formats) +
                '}';
    }
}
