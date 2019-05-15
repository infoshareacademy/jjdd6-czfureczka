package com.infoshareacademy.jjdd6.czfureczka.servlet;


import com.infoshareacademy.jjdd6.czfureczka.core.DepartureWithTime;
import com.infoshareacademy.jjdd6.czfureczka.core.ListStops;
import com.infoshareacademy.jjdd6.czfureczka.database.PromotedStop;
import com.infoshareacademy.jjdd6.czfureczka.database.PromotedStopDao;
import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/stops")
public class StopsServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(StopsServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    DepartureWithTime departureWithTime;

    @Inject
    ListStops listStops;

    @Inject
    PromotedStopDao promotedStopDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "stops.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<String> names = listStops.getListAllStops();
        model.put("stops", names);

        model.put("promotedStops", promotedStopDao.findAll(PromotedStop.class).stream()
                .sorted(Comparator.comparing(PromotedStop::getTag))
                .distinct()
                .collect(Collectors.toList()));

        if (req.getParameter("initialStop") != null && !req.getParameter("initialStop").isEmpty()) {
            if (req.getParameter("time") != null && !req.getParameter("time").isEmpty()) {
                model.put("result", departureWithTime.getTimetableForStop(req.getParameter("initialStop"), req.getParameter("time")));
            }
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

}
