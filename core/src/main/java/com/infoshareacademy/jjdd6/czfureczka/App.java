package com.infoshareacademy.jjdd6.czfureczka;

import com.infoshareacademy.jjdd6.czfureczka.Transfer.Transfer;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
        }
        Transfer transfer = new Transfer();
        Map<Integer, List<String>> result =  transfer.transfer("Akademia Muzyczna", "Sikorskiego");
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
