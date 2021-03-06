package com.infoshareacademy.jjdd6.czfureczka.servlet;

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
import java.util.*;
import java.util.logging.Logger;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ErrorServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdministratorDao administratorDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "error.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<String> images = List.of("/image/error/1_640.jpg",
                "/image/error/2_640.jpg",
                "/image/error/3_640.jpg",
                "/image/error/4_640.jpg",
                "/image/error/5_640.jpg",
                "/image/error/6_640.jpg",
                "/image/error/7_640.jpg");
        List<String> newImages = new ArrayList<>(images);
        Collections.shuffle(newImages);
        String firstPhoto = newImages.remove(0);
        model.put("firstPhoto", firstPhoto);
        model.put("images", newImages);

        String googleUserName = (String) req.getSession().getAttribute("google_name");
        String email = (String) req.getSession().getAttribute("email");
        model.put("google_name", googleUserName);

        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null || servletName.equals("default")) {
            servletName = "tajemnica";
        }

        model.put("statusCode", statusCode);
        model.put("servletName", servletName);

        if (email != null && !email.isEmpty()) {
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty()) {
                model.put("administrator", "yes");
            }
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
}
