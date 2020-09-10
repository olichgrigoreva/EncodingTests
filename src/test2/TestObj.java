package test2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class TestObj {

    @XmlElement
    private String status;

    @JsonProperty("status_code")
    @XmlElement(name = "status_code")
    private String code;

    @JsonProperty("status_tag")
    @XmlElement(name = "status_tag")
    public String tag;

    @JsonProperty("incident_count")
    @XmlElement(name = "incident_count")
    IncidentCount incidentCount;

    @XmlElement
    public int uptime;

    @XmlElement
    public Uptimes uptimes;

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "\nstatus='" + status + '\'' +
                ",\n code='" + code + '\'' +
                ",\n tag='" + tag + '\'' +
                ",\n incidentCount=" + incidentCount +
                ",\n uptime=" + uptime +
                ",\n uptimes=" + uptimes;
    }

    /**
     * status равен Ok; lastYear равен 1; uptime (сек) больше 1 суток
     * @param testObj объект с параметрами из JSON
     */
    public static void trueFalse(TestObj testObj) {
        if (testObj.getStatus().equals("Ok")) {
            System.out.printf("status равен Ok: %s %n", true);
        }

        int lastYear = testObj.incidentCount.lastYear;
        if (lastYear == 1) {
            System.out.printf("lastYear равен 1: %s %n", true);
        }

        float day;
        day = testObj.uptime / 86400;
        if (day > 1) {
            System.out.printf("uptime (сек) больше 1 суток: %s %n", true);
        }
    }
}

class IncidentCount{
    @XmlElement
    public int lastMonth;

    @XmlElement
    public int lastYear;

    @Override
    public String toString() {
        return "{" +
                "lastMonth=" + lastMonth +
                ", lastYear=" + lastYear +
                '}';
    }
}

class Uptimes {
    @XmlElement
    public String today;

    @XmlElement
    public String week;

    @XmlElement
    public String month;

    @Override
    public String toString() {
        return "{" +
                "today='" + today + '\'' +
                ", week='" + week + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
