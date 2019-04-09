package com.infoshareacademy.jjdd6.czfureczka;



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
/*
        AllStops allStops=new AllStops();
        allStops.run();
*/

    }


}
