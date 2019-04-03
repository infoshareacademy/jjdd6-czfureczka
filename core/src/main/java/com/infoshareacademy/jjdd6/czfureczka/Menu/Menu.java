package com.infoshareacademy.jjdd6.czfureczka.Menu;

import java.util.Scanner;

public class Menu {

    public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Suma");
        System.out.println("     2. Sinus");
        System.out.println("     3. Informaja");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }
}
