package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.core.ListStops;
import com.infoshareacademy.jjdd6.czfureczka.core.Trip;
import com.infoshareacademy.jjdd6.czfureczka.database.Administrator;
import com.infoshareacademy.jjdd6.czfureczka.database.AdministratorDao;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.TripWithTransfer;
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

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(TransferServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private PromotedStopDao promotedStopDao;

    @Inject
    private AdministratorDao administratorDao;

    @Inject
    private ListStops listStops;

    @Inject
    private Trip trip;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "transfer.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<String> names = listStops.getListAllStops();
        model.put("stops", names);

        String email = (String) req.getSession().getAttribute("email");
        model.put("promotedStops", promotedStopDao.findByEmail(PromotedStop.class, email).stream()
                .sorted(Comparator.comparing(PromotedStop::getTag))
                .distinct()
                .collect(Collectors.toList()));

        if (email != null && !email.isEmpty()){
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty()){
                model.put("administrator", "yes");
            }
        }

        if (req.getParameter("initialStop") != null && !req.getParameter("initialStop").isEmpty()) {
            if (req.getParameter("destinationStop") != null && !req.getParameter("destinationStop").isEmpty()) {

                List<String> directTrip = trip.getDirectTrip(req.getParameter("initialStop"), req.getParameter("destinationStop"));
                if (directTrip.size() == 0) {
                    List<TripWithTransfer> transfer = trip.getTrip(req.getParameter("initialStop"), req.getParameter("destinationStop"));

                    if (transfer.size() != 0) {
                        model.put("transfer", transfer);
                    } else {
                        model.put("noConnection", "No connection");
                    }

                } else {
                    model.put("trip", directTrip);
                }

            } else {
                model.put("deficiency", "deficiency");
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

    static void savePromotedStop(HttpServletRequest req, ListStops listStops, PromotedStopDao promotedStopDao) {
        PromotedStop stop = new PromotedStop();
        if (req.getSession().getAttribute("email") != null) {
            if (req.getParameter("nameStop") != null && !req.getParameter("nameStop").isEmpty()) {
                if (listStops.checkNameOfStop(req.getParameter("nameStop"))) {
                    stop.setName(req.getParameter("nameStop"));
                    String email = (String) req.getSession().getAttribute("email");
                    stop.setEmail(email);
                }

                if (req.getParameter("tag") != null && !req.getParameter("tag").isEmpty()) {
                    stop.setTag(req.getParameter("tag"));
                } else {
                    stop.setTag("Ulubiony");
                }

                promotedStopDao.save(stop);
            }
        }
    }
}
