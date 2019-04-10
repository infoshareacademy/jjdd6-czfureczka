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

        Menu run = new Menu();
        run.run();

    }
}


