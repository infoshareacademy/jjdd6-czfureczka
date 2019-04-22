package com.infoshareacademy.jjdd6.czfureczka.validation;

import com.infoshareacademy.jjdd6.czfureczka.fakeData.FakeData;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @BeforeAll
    static void setup(){
        FakeData fake = new FakeData();
        Repository.getInstance().setStops(fake.fakeStops());
        Repository.getInstance().setRoutes(fake.fakeRoutes());
    }

    private Validation validation = new Validation();

    @Test
    void validationOfStopNameWithCorrectString() {
        Assertions.assertThat(validation.validationOfStopName("Akademia Muzyczna"))
                .isNotNull()
                .isTrue();
    }
    @Test
    void validationOfStopNameWithCorrectStringWithWhitespace() {
        Assertions.assertThat(validation.validationOfStopName(" Akademia Muzyczna "))
                .isNotNull()
                .isTrue();
    }

    @Test
    void validationOfStopNameWithNull() {
        Assertions.assertThat(validation.validationOfStopName(null))
                .isFalse();
    }

    @Test
    void validationOfStopNameWithEmptyString() {
        Assertions.assertThat(validation.validationOfStopName(""))
                .isFalse();
    }

    @Test
    void validationOfStopNameWithIncorrectData() {
        Assertions.assertThat(validation.validationOfStopName("skfhdhgsdk"))
                .isFalse();
    }

    @Test
    void validationOfRoutNameWithCorrectString() {
        Assertions.assertThat(validation.validationOfRoutName("3"))
                .isNotNull()
                .isTrue();
    }

    @Test
    void validationOfRoutNameWithCorrectStringWithWhitespace() {
        Assertions.assertThat(validation.validationOfRoutName(" 3 "))
                .isNotNull()
                .isTrue();
    }

    @Test
    void validationOfRoutNameWithNull() {
        Assertions.assertThat(validation.validationOfRoutName(null))
                .isFalse();
    }

    @Test
    void validationOfRoutNameWithEmptyString() {
        Assertions.assertThat(validation.validationOfRoutName(""))
                .isFalse();
    }

    @Test
    void validationOfRoutNameWithIncorrectData() {
        Assertions.assertThat(validation.validationOfRoutName("skfhdhgsdk"))
                .isFalse();
    }
}