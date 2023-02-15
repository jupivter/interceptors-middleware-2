package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import co.develhope.interceptorsmiddleware2.services.MonthService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private MonthService monthService;
    private List<Month> monthList;

    public MonthInterceptor  () throws Exception {
        this.monthService = new MonthService();
        this.monthList = new ArrayList<>();
        for(int i=0; i<6;i++) {
            monthList.add(monthService.createMonthFromNumber(i+1));
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(monthList.isEmpty()){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        Integer monthNumber = Integer.valueOf(request.getHeader("monthNumber"));
        response.setStatus(HttpServletResponse.SC_OK);
        if(monthList.stream().map(Month::getMonthNumber).collect(Collectors.toSet()).contains(monthNumber)){
            request.setAttribute("isMonthInList","true");
        }
        else {
            request.setAttribute("isMonthInList", "false");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
