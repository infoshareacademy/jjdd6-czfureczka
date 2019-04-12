package com.infoshareacademy.jjdd6.czfureczka.timeAndDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Time {

    public static List<Date> stringConvertToTime(List<String > string){

       List <String> time = Arrays.asList("18:15:18","09:00:18","15:30:18");

        DateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        time.forEach(s -> sdf.parse(String.valueOf(time));



        System.out.println(time);
    //   List<Time> times=time.stream();
    //    time.stream()
     //           .peek()

     //   Date date = sdf.parse(time);






        return timeee;
    }
}
