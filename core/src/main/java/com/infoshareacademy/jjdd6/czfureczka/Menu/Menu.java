package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.time.LocalDate;
import java.time.LocalTime;

public class Menu {

    public void run(){

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        System.out.println(" ");
        System.out.println("Witaj w aplikacji 'Szybko do Celu'! Dzisiaj na pewno dojedziesz na czas :)");
        System.out.println("               Data: "+today+" "+"Godzina: "+now );
        System.out.println("__________________________________________________________________________");



    }
}
