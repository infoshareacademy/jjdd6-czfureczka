package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.oneChange.OneChange;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }
        OneChange oneChange = new OneChange();
        System.out.println(oneChange.checkSharedTrip("Dworzec Główny", "Akademia Muzyczna"));
        System.out.println("-------------------------------");
        System.out.println(oneChange.oneChange("Dworzec Główny", "Akademia Muzyczna"));

    }


}
