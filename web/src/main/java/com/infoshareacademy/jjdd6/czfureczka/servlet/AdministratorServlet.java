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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/admin")
public class AdministratorServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdministratorServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    AdministratorDao administratorDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");
        Map<String, Object> model = new HashMap<>();

        String googleUserName = (String) req.getSession().getAttribute("google_name");
        String email = (String) req.getSession().getAttribute("email");
        model.put("google_name", googleUserName);

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = (String) req.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()) {
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty() && administratorList.get(0).isAddNewAdministrator()) {

                Administrator admin = new Administrator();
                if (req.getAttribute("email") != null) {
                    List<Administrator> adminList = administratorDao.findByEmail(Administrator.class, req.getParameter("email"));
                    if (adminList.isEmpty()) {
                        admin.setEmail(req.getParameter("email"));

                        if (req.getParameter("addNewAdministrator") != null && req.getParameter("addNewAdministrator").equals("on")) {
                            admin.setAddNewAdministrator(true);
                        } else {
                            admin.setAddNewAdministrator(false);
                        }
                        if (req.getParameter("deleteAdministrator") != null && req.getParameter("deleteAdministrator").equals("on") && administratorList.get(0).isDeleteAdministrator()) {
                            admin.setDeleteAdministrator(true);
                        } else {
                            admin.setDeleteAdministrator(false);
                        }
                        administratorDao.save(admin);
                    }
                }
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()) {
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty() && administratorList.get(0).isDeleteAdministrator()) {

                if (req.getAttribute("email") != null) {
                    List<Administrator> admins = administratorDao.findByEmail(Administrator.class, req.getParameter("email"));
                    if (admins != null && admins.size() == 1) {
                        Administrator administrator = admins.get(0);
                        if (req.getParameter("addNewAdministrator") != null && req.getParameter("addNewAdministrator").equals("on")) {
                            administrator.setAddNewAdministrator(true);
                        } else {
                            administrator.setAddNewAdministrator(false);
                        }
                        if (req.getParameter("deleteAdministrator") != null && req.getParameter("deleteAdministrator").equals("on")) {
                            administrator.setDeleteAdministrator(true);
                        } else {
                            administrator.setDeleteAdministrator(false);
                        }
                        administratorDao.update(administrator);
                    }
                }
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()) {
            List<Administrator> administratorList = administratorDao.findByEmail(Administrator.class, email);
            if (!administratorList.isEmpty() && administratorList.get(0).isDeleteAdministrator()) {
                if (req.getAttribute("email") != null) {
                    List<Administrator> admins = administratorDao.findByEmail(Administrator.class, req.getParameter("email"));
                    String test = "abc";
                    if (admins != null && admins.size() == 1) {
                        Administrator administrator = admins.get(0);
                        administratorDao.delete(Administrator.class, administrator.getId());
                    }
                }
            }
        }
    }
}