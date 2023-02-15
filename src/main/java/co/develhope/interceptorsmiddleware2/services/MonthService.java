package co.develhope.interceptorsmiddleware2.services;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.stereotype.Component;

@Component
public class MonthService {


    public Month createNopeMonth () {
        return new Month(0,"nope","nope","nope");
    }

    public Month createMonthFromNumber(Integer number) throws Exception {
        switch (number) {
            case 1 -> {
                return new Month(1, "January", "Gennaio", "...");
            }
            case 2 -> {
                return new Month(2, "February", "Febbraio", "...");
            }
            case 3 -> {
                return new Month(3, "March", "Marzo", "...");
            }
            case 4 -> {
                return new Month(4, "April", "aprile", "..");
            }
            case 5 -> {
                return new Month(5, "may", "maggio", ",,,");
            }
            case 6 -> {
                return new Month(6, "june", "giugno", "...");
            }
            case 7 -> {
                return new Month(7, "july", "luglio", "...");
            }
            case 8 -> {
                return new Month(8, "august", "agosto", "...");
            }
            case 9 -> {
                return new Month(9, "september", "settemner", "...");
            }
            case 10 -> {
                return new Month(10, "october", "ottobre", "...");
            }
            case 11 -> {
                return new Month(11, "november", "novembre", "...");
            }
            case 12 -> {
                return new Month(12, "december", "dicember", "...");
            }
        }
        throw new Exception("The number must be between 1 and 12");
    }
}
