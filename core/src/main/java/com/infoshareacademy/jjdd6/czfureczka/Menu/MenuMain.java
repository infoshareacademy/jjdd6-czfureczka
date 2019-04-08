package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class MenuMain {

    public static void main(String[] args) throws FileNotFoundException {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();


        System.out.println(" ");
        System.out.println("Witaj w aplikacji Szybko do Celu! Dzisiaj na pewno dojedziesz na czas :) ");
        System.out.println("              Data: " + today + " " + "Godzina: " + now + "                      ");
        System.out.println("_________________________________________________________________________");

        System.out.println("Wybierz opcje:");
        System.out.println("1.Odjazd z przystanku.");
        System.out.println("2.Relacja przystanek-przystanek.");
        System.out.println(" ");

        Scanner scan = new Scanner(System.in);
        System.out.print("Twoj wybor:");
        Integer wybor = scan.nextInt();

        int number = wybor;
        switch (number) {

            case 1:
                System.out.print("Wpisz przystanek startowy: ");
                System.out.println(" ");

                Scanner scan2 = new Scanner(System.in);
                System.out.println("Przystenk startowy:");
                String startowy = scan.nextLine();
                System.out.println("Dostepne polacznia:");

                Scanner scan3 = new Scanner(System.in);
                System.out.print("Wybierz polaczenie:");
                Integer polaczenie = scan3.nextInt();

            case 2:

                Scanner scan4 = new Scanner(System.in);
                System.out.println("Wpisz przystanek startowy: ");
                String start = scan.nextLine();

                Scanner scan5 = new Scanner(System.in);
                System.out.println("Wpisz przystanek docelowy: ");
                String docelowy = scan.nextLine();

                System.out.println("Relacja:" + start + "-" + docelowy);

                System.out.println("Dostepne polaczenia:");

                Scanner scan6 = new Scanner(System.in);
                System.out.print("Wybierz polaczenie:");
                Integer polaczenie2 = scan.nextInt();

                int number2 = polaczenie2;
                switch (number2) {
                    case 1:
                        System.out.println("Najblizszy odjazd: ");
                    case 2:
                        System.out.println("Najblizszy odjazd: ");
                    case 3:
                        System.out.println("Najblizszy odjazd: ");
                }


        }
    }
}


