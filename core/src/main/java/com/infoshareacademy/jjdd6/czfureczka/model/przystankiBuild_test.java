package com.infoshareacademy.jjdd6.czfureczka.model;


import java.security.Key;
import java.util.List;
import static com.infoshareacademy.jjdd6.czfureczka.model.BuildStopsObjectArray.*;
import static com.infoshareacademy.jjdd6.czfureczka.repository.Repository.getInstance;

public class przystankiBuild_test {


    public static void main(String[] args) {


        //String dateScope = "2019-04-09";
        List<Stop> PRZYSTANKI = buildStopsArrayList();

        for (Stop o : PRZYSTANKI) {
            System.out.println(o.getStopName()+","+o.getStopId());
        }
    }
}
