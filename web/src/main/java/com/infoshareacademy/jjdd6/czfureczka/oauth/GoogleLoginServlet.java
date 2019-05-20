package com.infoshareacademy.jjdd6.czfureczka.oauth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

@WebServlet("/googlelogin")
public class GoogleLoginServlet extends AbstractAuthorizationCodeServlet {

    private static final Logger logger = Logger.getLogger(GoogleLoginServlet.class.getName());


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
