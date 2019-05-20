package com.infoshareacademy.jjdd6.czfureczka.oauth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

@WebServlet("/oauth2callback")
public class GoogleLoginCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

    private static final Logger logger = Logger.getLogger(GoogleLoginCallbackServlet.class.getName());


    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
            throws ServletException, IOException {
        logger.info("Google auth success");
        GoogleCredential gCredential = new GoogleCredential().setAccessToken(credential.getAccessToken());
        Oauth2 oauth2 = new Oauth2.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                gCredential
        )
                .setApplicationName("Szybko do celu")
                .build();
        Userinfoplus info = oauth2.userinfo().get().execute();
        String name = info.getName();
        String email = info.getEmail();
        req.getSession().setAttribute("google_name", name);
        req.getSession().setAttribute("email", email);
        resp.sendRedirect("/menu");
    }

    @Override
    protected void onError(
            HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
            throws ServletException, IOException {
        logger.severe("Google auth error: " + errorResponse.getError());
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
        return GoogleLoginCommons.buildRedirectUri(req);
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
        return GoogleLoginCommons.buildFlow();
    }

    @Override
    protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
        String randomUserId = UUID.randomUUID().toString();
        logger.info("getUserId: " + randomUserId);
        return randomUserId;
    }
}
