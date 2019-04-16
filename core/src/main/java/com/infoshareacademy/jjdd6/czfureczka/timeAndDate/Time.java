package com.infoshareacademy.jjdd6.czfureczka.timeAndDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Time {

    public static List<String> stringConvertToTime(List<String > string){

       List <String> time = Arrays.asList("18:15:18","09:00:18","15:30:18");

        DateFormat sdf = new SimpleDateFormat("HH:mm:ss");

         time.forEach(s -> {
            try {
                sdf.parse(String.valueOf(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });



        System.out.println(time);
    //   List<Time> times=time.stream();
    //    time.stream()
     //           .peek()

     //   Date date = sdf.parse(time);


        return time;
    }
}
