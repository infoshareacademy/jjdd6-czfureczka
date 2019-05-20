package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.czfureczka.statistic.PopularStop;
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
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/start")
public class StartingServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(StartingServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    public StartingServlet() throws IOException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

    Template template = templateProvider.getTemplate(getServletContext(), "landingPage.ftlh");
    Map<String, Object> model = new HashMap<>();

    logger.info("Keys in template model: " + model.keySet().stream().collect(Collectors.joining(", ")));


        try {
            template.process(model, resp.getWriter());
        } catch (
                TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

}
