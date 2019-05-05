package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.agency.ModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.core.ListRoute;
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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/stopTimes")
public class StopTimesServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(StopTimesServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    ListRoute listRoute;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "stopTimes.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("bus", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.BUS));
        model.put("tram", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.TRAM));
        model.put("trolleybus", listRoute.getListOfAllLinesForTypeVehicle(ModeOfTransportation.TROLLEYBUS));

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
