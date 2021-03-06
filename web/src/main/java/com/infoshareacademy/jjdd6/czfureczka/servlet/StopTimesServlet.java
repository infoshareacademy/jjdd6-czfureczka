package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.agency.ModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.core.DepartureWithTime;
import com.infoshareacademy.jjdd6.czfureczka.core.ListRoute;
import com.infoshareacademy.jjdd6.czfureczka.database.Administrator;
import com.infoshareacademy.jjdd6.czfureczka.database.AdministratorDao;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/stopTimes")
public class StopTimesServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(StopTimesServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ListRoute listRoute;

    @Inject
    private DepartureWithTime departureWithTime;

    @Inject
    private AdministratorDao administratorDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "stopTimes.ftlh");
        Map<String, Object> model = new HashMap<>();

        String email = (String) req.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()){
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty()){
                model.put("administrator", "yes");
            }
        }

        model.put("bus", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.BUS));
        model.put("tram", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.TRAM));
        model.put("trolleybus", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.TROLLEYBUS));


        if (req.getParameter("routeId") != null && !req.getParameter("routeId").isEmpty()) {
            if (req.getParameter("stop") == null || req.getParameter("stop").isEmpty()) {
                model.put("listStops", listRoute.getListStopsInTrip(req.getParameter("routeId")));
                model.put("routeId", listRoute.getNameRoute(req.getParameter("routeId")));
            }
        }

        if (req.getParameter("tripId") != null && !req.getParameter("tripId").isEmpty()) {
            if (req.getParameter("routeId") != null && !req.getParameter("routeId").isEmpty()) {
                if (req.getParameter("stop") != null && !req.getParameter("stop").isEmpty()) {

                    try {
                        model.put("time", departureWithTime.getFullTimetableForView(req.getParameter("stop"), req.getParameter("tripId"), req.getParameter("routeId")));
                    } catch (Exception e) {
                        List<String> error = new ArrayList<>();
                        error.add("Brak danych");
                        model.put("time", error);
                    }
                    model.put("routeId", listRoute.getNameRoute(req.getParameter("routeId")));
                    model.put("stop", req.getParameter("stop"));
                }
            }
        }
        String googleUserName = (String) req.getSession().getAttribute("google_name");
        model.put("google_name", googleUserName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
