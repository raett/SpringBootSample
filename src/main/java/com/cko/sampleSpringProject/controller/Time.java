package com.cko.sampleSpringProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {


    public static List<String> giveTimeOrders() {
        List<String> t = new ArrayList<>();
        for (int i = 9; i < 22; i++) {
            String time = i + " : 00";
            t.add(time);
            time = i + " : 30";
            t.add(time);
        }
        return t;

    }

    public static List<String> giveFiveWorkingDays() {
        List<String> day = new ArrayList<>();
        LocalDate today = LocalDate.now();
        while (day.size() < 5) {
            today = today.plusDays(1);
            int dayOfweek = today.getDayOfWeek().getValue();
            if (dayOfweek != 6 && dayOfweek != 7) {
                String thisDay = today.toString();
                day.add(thisDay);
            }
        }
        ;
        return day;

    }

    public static List<String> giveFiveCalendarDays() {
        List<String> day = new ArrayList<>();
//        LocalDate today = LocalDate.now();
//        while (day.size() < 5) {
//            if (day.size() < 2) {
//                today = today.plusDays(-1);
//                int dayOfweek = today.getDayOfWeek().getValue();
//                if (dayOfweek != 6 && dayOfweek != 7) {
//                    String thisDay = today.toString();
//                    day.add(thisDay);
//                } else {
//                    today = today.plusDays(1);
//                    int d = today.getDayOfWeek().getValue();
//                    if (d != 6 && d != 7) {
//                        String thisDay = today.toString();
//                        day.add(thisDay);
//                    }
//
//                }
//            }
        return day;
    }


//    public Time() {
//        List<String> t = new ArrayList<>();
//        for(int i = 9; i < 22; i++){
//            String time = i + " : 00";
//            t.add(time);
//            time = i + " : 30";
//            t.add(time);
//        }
//        this.times = t;
//    }

}
