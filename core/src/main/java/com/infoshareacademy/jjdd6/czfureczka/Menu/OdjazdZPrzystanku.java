package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.util.Scanner;

public class OdjazdZPrzystanku {

    public void run(){

        Scanner scan= new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start = scan.nextLine();
        System.out.println("Przystanek "+ start + " - dostepne polaczenia: ");

        System.out.println("Wybierz polacznie: ");
        Integer connection = scan.nextInt();
    }
}

