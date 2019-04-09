package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.util.Scanner;

public class RelacjaP_P {

    public void run()

    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz przystanek startowy: ");
        String start2 = scan.nextLine();

        System.out.println("Wpisz przystanek docelowy: ");
        String destination = scan.nextLine();

        System.out.println("Relacja " + start2 + "-" + destination);
        System.out.println("Dostepne polaczenia: ");

        System.out.print("Wybierz polaczenie: ");
        Integer connnection2 = scan.nextInt();

    }


}
