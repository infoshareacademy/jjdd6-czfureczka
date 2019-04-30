package com.infoshareacademy.jjdd6.czfureczka.servlet;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/menu")
public class Menu extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    ListStops listStops;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Cookie counter = getCounterCookie(req.getCookies());
        int newCounter = Integer.parseInt(counter.getValue()) + 1;

        resp.addCookie(new Cookie("counter", String.valueOf(newCounter)));

        Template template = templateProvider.getTemplate(getServletContext(), "menu.ftlh");
        Map<String, Object> model = new HashMap<>();
        List<String> names = listStops.getListStops();

        model.put("stops", names);
        model.put("counter", newCounter);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
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
