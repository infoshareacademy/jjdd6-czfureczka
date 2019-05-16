package com.infoshareacademy.jjdd6.czfureczka.oauth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class GoogleLoginCommons {
    private static final List<String> scopes = List.of("openid", "email", "profile");

    private static final String clientId = "649230442291-rp5fkj2r37t9ljbjn05sj19ahgeq5rp0.apps.googleusercontent.com";

    private static final String secret = "WRd2haO_yMJ0KJAqXChdxuiy";

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
