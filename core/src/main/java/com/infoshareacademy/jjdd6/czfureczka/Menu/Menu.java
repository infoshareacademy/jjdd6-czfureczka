package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public void run(){

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        Scanner scan = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Witaj w aplikacji 'Szybko do Celu'! Dzisiaj na pewno dojedziesz na czas :)");
        System.out.println("               Data: "+today+" "+"Godzina: "+now.format(dtf) );
        System.out.println("__________________________________________________________________________");
        System.out.println(" ");

        System.out.println("Wybierz opcje: ");
        System.out.println("1. Odjazd z przystanku.");
        System.out.println("2. Relacja przystanek-przystanek. ");
        System.out.println(" ");

        System.out.print("Twoj wybor: ");
        Integer option = Integer.valueOf(scan.nextLine());

        switch (option){

            case 1:

                OdjazdZPrzystanku odjazd = new OdjazdZPrzystanku();
                odjazd.run();
                break;

            case 2:

                RelacjaP_P relacja = new RelacjaP_P();
                relacja.run();
                break;
        }
    }
}
