package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.core.ListRoute;
import com.infoshareacademy.jjdd6.czfureczka.core.ListStops;
import com.infoshareacademy.jjdd6.czfureczka.core.Trip;
import com.infoshareacademy.jjdd6.czfureczka.database.*;
import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/menu")
public class Menu extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ListStops listStops;

    @Inject
    private ListRoute listRoute;

    @Inject
    private StopStatisticDao stopStatisticDao;

    @Inject
    private PromotedStopDao promotedStopDao;

    @Inject
    private Trip trip;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Cookie counter = getCounterCookie(req.getCookies());
        int newCounter = Integer.parseInt(counter.getValue()) + 1;

        resp.addCookie(new Cookie("counter", String.valueOf(newCounter)));

        Template template = templateProvider.getTemplate(getServletContext(), "menu.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (req.getParameter("initialStop") != null && !req.getParameter("initialStop").isEmpty()) {
            String stop = req.getParameter("initialStop");
            stop = trip.cropTagFromStopName(stop);
            Boolean result = listStops.checkNameOfStop(stop);
            logger.info("The given stop exists: " + result.toString());
            model.put("stopDesc", result);
            if (result) {
                LocalDate now = LocalDate.now();
                stopStatisticDao.save(new StopStatistic(stop, now));
            }
        }

        if (req.getParameter("routeId") != null && !req.getParameter("routeId").isEmpty()) {
            String routeId = req.getParameter("routeId");
            Boolean result = listRoute.checkNameOfRoute(routeId);
            logger.info("The given route exists: " + result.toString());
            model.put("routeId", result);

        }

        List<String> names = listStops.getListAllStops();

        model.put("stops", names);
        model.put("promotedStops", promotedStopDao.findAll(PromotedStop.class).stream()
                .sorted(Comparator.comparing(PromotedStop::getTag))
                .distinct()
                .collect(Collectors.toList()));
        model.put("counter", newCounter);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("Method doPost; request parameters: 'nameStop': " + req.getParameter("nameStop") + " and 'tag': " + req.getParameter("tag"));
        TransferServlet.savePromotedStop(req, listStops, promotedStopDao);

    }

    private Cookie getCounterCookie(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("counter")) {
                    return c;
                }
            }
        }

        return new Cookie("counter", String.valueOf(0));
    }

}
