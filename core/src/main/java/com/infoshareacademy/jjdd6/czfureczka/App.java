package com.infoshareacademy.jjdd6.czfureczka;


import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println("Data could not be loaded");
            return;
        }

        List<Integer> data = Repository.getInstance().getStopTimes().keySet().stream()
                .collect(Collectors.toList());

        //  data.forEach(System.out::println);

        List<Integer> neww = Arrays.asList(2, 12);

      //  neww.forEach(System.out::println);

     //Stream.of(data,neww).filter(s,b)->neww.contains(data)).forEach(System.out::println);

data.retainAll(neww);
System.out.println(data);

       List<Integer> routShortNames = data.stream()
                .filter(s-> data.contains(neww))
                .collect(Collectors.toList());
        routShortNames.forEach(System.out::println);


    }


}
