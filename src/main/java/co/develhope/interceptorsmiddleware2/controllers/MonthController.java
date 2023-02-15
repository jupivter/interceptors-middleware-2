package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.services.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/months")
public class MonthController {

    @Autowired
    MonthService monthService;

    @GetMapping("/")
    public Map<String, String> getMonth (@RequestHeader(name = "monthNumber")Integer monthNumber,
                                         @RequestAttribute(name = "isMonthInList")String isMonthInList)
            throws Exception
    {
        if(isMonthInList.equals("true")){
            return monthService.createMonthFromNumber(monthNumber).toMap();
        }
        Map<String,String> nopeMonthMap = monthService.createNopeMonth().toMap();
        nopeMonthMap.put("monthNumber","nope");
        return nopeMonthMap;
    }
}
