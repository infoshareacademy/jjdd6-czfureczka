package com.infoshareacademy.jjdd6.czfureczka.service;

import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

@Singleton
@Startup
public class DataProvider {

    private static final Logger logger = Logger.getLogger(DataProvider.class.getName());

    @PostConstruct
    public void initialize() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();

        if (repositoryLoader.load("data")) {
            logger.info("Data loaded");
        } else {
            logger.severe("Data could not be loaded");
        }
    }
}
