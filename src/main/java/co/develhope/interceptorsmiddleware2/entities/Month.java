package co.develhope.interceptorsmiddleware2.entities;

import java.util.HashMap;
import java.util.Map;

public class Month {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Month () {}

    public Month(Integer monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Map<String,String> toMap () {
        Map map = new HashMap();
        map.put("monthNumber",String.valueOf(monthNumber));
        map.put("englishName",englishName);
        map.put("italianName",italianName);
        map.put("germanName",germanName);
        return map;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }
}