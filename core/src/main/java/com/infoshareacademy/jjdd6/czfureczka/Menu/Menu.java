package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    public void run() throws InterruptedException {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        Scanner scan = new Scanner(System.in);

        System.out.println(" ____________________________________________________________________________");
        System.out.println("|                                                                            |");
        System.out.println("|                       Witaj w aplikacji 'Szybko do Celu'!                  |");
        System.out.println("|                      Dzisiaj na pewno dojedziesz na czas :)                |");
        System.out.println("|                               Data: " + today +"                             |");
        System.out.println("|                               Godzina: "+" "+ now.format(dtf)+"                              |");
        System.out.println("|____________________________________________________________________________|");
        System.out.println(" ");

        System.out.println("***************************** WYBIERZ OPCJE ************************************");
        System.out.println("*   1. Odjazd z przystanku. **************** 2. Relacja przystanek-przystanek. *" );
        System.out.println("*****************************              *************************************") ;
        System.out.println(" ");

        System.out.print("                             WPISZ NUMER: ");
        Integer option = run2();


        while (option != 1 && option != 2) {
            System.out.println("Wybrales zle, sprobuj ponownie");
            System.out.print("Twoj wybor: ");
            option = run2();
        }


        switch (option) {

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

        public Integer run2 (){

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        List<String> cyferki = new ArrayList<>();
        cyferki.add("0");
        cyferki.add("1");
        cyferki.add("2");
        cyferki.add("3");
        cyferki.add("4");
        cyferki.add("5");
        cyferki.add("6");
        cyferki.add("7");
        cyferki.add("8");
        cyferki.add("9");

        String[] zamiana = option.split("");
            List<String> test1 = Arrays.stream(zamiana)
                    .filter(s->cyferki.contains(s))
                    .collect(Collectors.toList());

            if (zamiana.length == test1.size()){
                return Integer.valueOf(option);
            }
            return 9999;

        }

}
