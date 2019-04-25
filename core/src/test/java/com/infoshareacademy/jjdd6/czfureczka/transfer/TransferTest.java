package com.infoshareacademy.jjdd6.czfureczka.transfer;

import com.infoshareacademy.jjdd6.czfureczka.fakeData.FakeData;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransferTest {

    @BeforeAll
    static void setup(){
        FakeData fake = new FakeData();
        Repository.getInstance().setStops(fake.fakeStops());
        Repository.getInstance().setRoutes(fake.fakeRoutes());
        Repository.getInstance().setStopsInTrip(fake.fakeStopInTrip());

    }

    private Transfer transfer = new Transfer();

    @Test
    void transferTestWithCorrectStops() {
        Map<Integer, List<String>> result = new HashMap<>();
        List<String> stringResult = new ArrayList<>();
        stringResult.add("2");
        stringResult.add("przesiadka na:");
        stringResult.add("Brama Wyżynna");
        stringResult.add("następnie pojedź:");
        stringResult.add("3");
        stringResult.add("Jesteś u celu!");
        result.put(0,stringResult);
        Assertions.assertThat(transfer.transfer("Akademia Muzyczna", "Sikorskiego"))
                .isNotNull()
                .isEqualTo(result);
    }
    @Test
    void transferTestWithIncorrectStops() {
        Assertions.assertThat(transfer.transfer("Reja", "Sikorskiego"))
                .isNotNull()
                .isEmpty();
    }
}