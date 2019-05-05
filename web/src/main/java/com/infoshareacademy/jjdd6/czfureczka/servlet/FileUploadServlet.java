package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import com.infoshareacademy.jjdd6.czfureczka.config.StopTimesConfig;
import com.infoshareacademy.jjdd6.czfureczka.config.Timetable;
import com.infoshareacademy.jjdd6.czfureczka.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.czfureczka.repository.RepositoryLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;


@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private final static String serverPath = "/home/paula/wildfly-16.0.0.Final/data/";

    private static final Logger logger = Logger.getLogger(StopTimesServlet.class.getName());

    public static List<String> liststring;


    @Inject
    TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "upload.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "uploadFile.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }

        final Part filePart = req.getPart("file");
        String fileName = getFileName(filePart);
        String fileName1 = fileName.replaceAll("[a-zA-Z]+", "");
        int routeId = Integer.parseInt(fileName1.replaceAll("[.]", ""));

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = resp.getWriter();

        try {
            out = new FileOutputStream(new File(serverPath + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
           logger.info("Plik " + fileName + " został zapisany pomyślnie");


        } catch (FileNotFoundException fne) {
            logger.info("Missing file or no insufficient permissions.");
            logger.severe(" ERROR: " + fne.getMessage());
        }
        finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }


        }

        try {
            JsonParser parser = new JsonParser();
            Object obj = parser.parse(new FileReader("/home/paula/wildfly-16.0.0.Final/data/config.json"));

            JsonObject jsonObject = (JsonObject) obj;
            liststring = new ArrayList<String>();

            JsonArray msg = (JsonArray) jsonObject.get("stopTimes");
            Iterator<JsonElement> iterator = msg.iterator();

            Timetable newVin = new Timetable();
            newVin.setRouteId(routeId);
            newVin.setFile(fileName);
            Gson gson = new Gson();

            FileWriter file = new FileWriter("/home/paula/wildfly-16.0.0.Final/data/config.json");
            JsonWriter jw = new JsonWriter(file);
            iterator = msg.iterator();
            StopTimesConfig vins = new StopTimesConfig();
            while (iterator.hasNext()) {
                vins.addStopTimesConfig(gson.fromJson(iterator.next().toString(), Timetable.class));
            }
            vins.addStopTimesConfig(newVin);
            gson.toJson(vins, StopTimesConfig.class, jw);
            file.close();

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

        RepositoryLoader repositoryLoader = new RepositoryLoader();

        if (repositoryLoader.load("data")) {
            logger.info("Data loaded");
        } else {
            logger.severe("Data could not be loaded");
        }
    }


    private String getFileName(Part filePart) {
        String header = filePart.getHeader("content-disposition");
        String name = header.substring(header.indexOf("filename=\"") + 10);
        return name.substring(0, name.indexOf("\""));
    }
}