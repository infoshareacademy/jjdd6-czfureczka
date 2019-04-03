package com.infoshare.jjdd6czfureczka.config;

import java.util.Map;

import static java.util.Map.entry;

public class RoutesConfig {

    public static Map<String, String> routesDataFiles = Map.ofEntries(
            entry("3", "stopTimes3.json"),
            entry("8", "stopTimes8.json"),
            entry("167", "stopTimes167.json")
    );


}
