package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.czfureczka.statistic.PopularRoute;
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

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ReportServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    PopularStop popularStop;

    @Inject
    PopularRoute popularRoute;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "report.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("result", popularStop.getMostPopularStop());

        if (req.getParameter("popularStops") != null && !req.getParameter("popularStops").isEmpty()){
            Integer limit = Integer.valueOf(req.getParameter("popularStops"));
            model.put("popularStops", popularStop.getSortStops(limit));
        }

        model.put("resultRoute", popularRoute.getMostPopularRoute());

        if (req.getParameter("popularRoutes") != null && !req.getParameter("popularRoutes").isEmpty()){
            Integer limit = Integer.valueOf(req.getParameter("popularRoutes"));
            model.put("popularRoutes", popularRoute.getSortRoutes(limit));
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
