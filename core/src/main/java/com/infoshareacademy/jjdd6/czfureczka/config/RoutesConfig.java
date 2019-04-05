package com.infoshareacademy.jjdd6.czfureczka.config;

import java.util.Map;

import static java.util.Map.entry;

public class RoutesConfig {

    public static Map<String, String> routesDataFiles = Map.ofEntries(
            entry("3", "data/stopTimes3.json"),
            entry("8", "data/stopTimes8.json"),
            entry("167", "data/stopTimes167.json")
    );


}
