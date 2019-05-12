package com.infoshareacademy.jjdd6.czfureczka.oauth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.tools.javac.util.List;

import javax.servlet.http.HttpServletRequest;

public class GoogleLoginCommons {
    private static final List<String> scopes = List.of("openid", "email", "profile");

    private static final String clientId = "PLACE YOUR CLIENT ID HERE";

    private static final String secret = "PLACE YOUR CLIENT SECRET HERE";

    private static final String redirectUrl = "/oauth2callback";

    public static String buildRedirectUri(HttpServletRequest req) {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath(redirectUrl);
        return url.build();
    }

    public static GoogleAuthorizationCodeFlow buildFlow() {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                clientId,
                secret,
                scopes
        )
                //.setDataStoreFactory(MemoryDataStoreFactory.getDefaultInstance())
                .setAccessType("online")
                .build();
    }
}
