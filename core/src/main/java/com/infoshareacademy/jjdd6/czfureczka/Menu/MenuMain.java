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
        System.out.println("              Data: "+today+" "+"Godzina: "+now+"                      ");
        System.out.println("_________________________________________________________________________");
        Scanner scan = new Scanner(System.in);
        System.out.print("1. Wpisz przystanek startowy: ");
        String startowy =scan.nextLine();
        Scanner scan2 = new Scanner(System.in);
        System.out.print("2. Wpisz przystanek docelowy: ");
        String docelowy =scan.nextLine();
        System.out.println("Relacja:"+startowy+"-"+docelowy);
        System.out.println("Dostepne polaczenia:");
        Scanner scan3 = new Scanner(System.in);
        System.out.print("Wybierz polaczenie:");
        Integer polaczenie = scan.nextInt();









        }
}


