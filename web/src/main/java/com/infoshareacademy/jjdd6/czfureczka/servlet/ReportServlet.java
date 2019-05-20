package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.database.Administrator;
import com.infoshareacademy.jjdd6.czfureczka.database.AdministratorDao;
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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ReportServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private PopularStop popularStop;

    @Inject
    private PopularRoute popularRoute;

    @Inject
    private AdministratorDao administratorDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "report.ftlh");
        Map<String, Object> model = new HashMap<>();

        String googleUserName = (String) req.getSession().getAttribute("google_name");
        model.put("google_name", googleUserName);

        String email = (String) req.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()){
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty()){
                model.put("administrator", "yes");
            }
        }

        if (popularStop.getAll().size() != 0) {
            model.put("result", popularStop.getMostPopularStop());

            if (req.getParameter("popularStops") != null && !req.getParameter("popularStops").isEmpty()) {
                Integer limit = Integer.valueOf(req.getParameter("popularStops"));
                model.put("popularStops", popularStop.getSortStops(limit));
            } else {
                model.put("popularStops", popularStop.getSortStops(1));
            }
        }

        if (popularRoute.getAll().size() != 0) {
            model.put("resultRoute", popularRoute.getMostPopularRoute());

            if (req.getParameter("popularRoutes") != null && !req.getParameter("popularRoutes").isEmpty()) {
                Integer limit = Integer.valueOf(req.getParameter("popularRoutes"));
                model.put("popularRoutes", popularRoute.getSortRoutes(limit));
            } else {
                model.put("popularRoutes", popularRoute.getSortRoutes(1));
            }
        }

        logger.info("Keys in template model: " + model.keySet().stream().collect(Collectors.joining(", ")));

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
