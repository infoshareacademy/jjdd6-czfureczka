package com.infoshareacademy.jjdd6.czfureczka.service;

import com.infoshareacademy.jjdd6.czfureczka.database.Administrator;
import com.infoshareacademy.jjdd6.czfureczka.database.AdministratorDao;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class DataProvider implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(DataProvider.class.getName());

    @Inject
    AdministratorDao administratorDao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        RepositoryLoader repositoryLoader = new RepositoryLoader();

        String path = sce.getServletContext().getRealPath("/WEB-INF/data");
        logger.info("Path to the data: " + path);

        Administrator admin = new Administrator();
        admin.setEmail("jjdd6czfureczka@gmail.com");
        admin.setAddNewAdministrator(true);
        admin.setDeleteAdministrator(true);
        administratorDao.save(admin);
        logger.info("Added new administrator");

        if (repositoryLoader.load(path)) {
            logger.info("Data loaded");
        } else {
            logger.severe("Data could not be loaded");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
