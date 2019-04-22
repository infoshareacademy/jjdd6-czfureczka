package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.fakeData.FakeData;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchForRouteShortNameTest {

    @BeforeAll
    static void setup(){
        FakeData fake = new FakeData();
        Repository.getInstance().setStops(fake.fakeStops());
        Repository.getInstance().setRoutes(fake.fakeRoutes());
        Repository.getInstance().setStopsInTrip(fake.fakeStopInTrip());
    }

    private SearchForRouteShortName search = new SearchForRouteShortName();

    @Test
    void lookingForShortNameWithCorrectString() {
        List<String> result = new ArrayList<>();
        result.add("2");
        Assertions.assertThat(search.lookingForShortName("Akademia Muzyczna"))
                .isNotNull()
                .isEqualTo(result);
    }

    @Test
    void lookingForShortNamesWithCorrectString() {
        List<String> result = new ArrayList<>();
        result.add("2");
        result.add("3");
        Assertions.assertThat(search.lookingForShortName("Brama Wyżynna"))
                .isNotNull()
                .isEqualTo(result);
    }

    @Test
    void lookingForShortNameWithIncorrectString() {
        List<String> result = new ArrayList<>();
        Assertions.assertThat(search.lookingForShortName("Wojska Polskiego"))
                .isNotNull()
                .isEqualTo(result);
    }
}