package com.infoshare.jjdd6czfureczka;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.jjdd6czfureczka.config.RoutesConfig;
import com.infoshare.jjdd6czfureczka.model.*;
import com.infoshare.jjdd6czfureczka.repository.Repository;
import com.infoshare.jjdd6czfureczka.repository.RepositoryLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load()) {
            System.out.println("Data loaded");
        } else {
            System.err.println();
            return;
        }

    }


}
