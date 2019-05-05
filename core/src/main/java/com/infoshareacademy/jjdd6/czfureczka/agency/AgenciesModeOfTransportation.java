package com.infoshareacademy.jjdd6.czfureczka.agency;

import java.util.Map;

import static java.util.Map.entry;

public class AgenciesModeOfTransportation {


    public static final Map<Integer, ModeOfTransportation> mapping = Map.ofEntries(
            entry(1, ModeOfTransportation.BUS),
            entry(2, ModeOfTransportation.TRAM),
            entry(5, ModeOfTransportation.TROLLEYBUS),
            entry(6, ModeOfTransportation.BUS),
            entry(7, ModeOfTransportation.BUS),
            entry(8, ModeOfTransportation.BUS),
            entry(9, ModeOfTransportation.BUS),
            entry(10, ModeOfTransportation.BUS),
            entry(11, ModeOfTransportation.BUS),
            entry(17, ModeOfTransportation.BUS),
            entry(18, ModeOfTransportation.BUS),
            entry(19, ModeOfTransportation.SHIP));
}
