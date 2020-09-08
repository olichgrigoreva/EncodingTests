package test1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Format {
    public String id;
    public String status;
    public String created;
    public String started;
    public String finished;
    @JsonProperty("s3_destination")
    public String sDestination;
    @JsonProperty("cf_destination")
    public String cfDestination;
    public String convertedsize;
    public String time_left;
    public String progress;
    public String time_left_current;
    public String progress_current;
    public String file_size;

    @Override
    public String toString() {
        return "Format{" +
                "status='" + status + '\'' +
                '}';
    }
}
