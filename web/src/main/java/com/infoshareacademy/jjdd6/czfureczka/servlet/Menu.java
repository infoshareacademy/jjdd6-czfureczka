package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/menu")
public class Menu extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        if (repositoryLoader.load(System.getProperty("settingsPath"))) {
            logger.info("Data loaded");
        } else {
            logger.severe("Data could not be loaded");
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "menu.ftlh");
        Map<String, Object> model = new HashMap<>();
        ListStops list = new ListStops();
        List<String> names = list.getListStops();

        model.put("stops", names);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
