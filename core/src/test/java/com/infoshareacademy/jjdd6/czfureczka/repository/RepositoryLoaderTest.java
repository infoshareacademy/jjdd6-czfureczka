package com.infoshareacademy.jjdd6.czfureczka.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class RepositoryLoaderTest {

    RepositoryLoader repository = new RepositoryLoader();

    @Test
    void loadWithoutData() {
        Assertions.assertThat(repository.load(""))
                .isFalse();
    }

    @Test
    void loadWithData() {

        URL url = this.getClass().getResource("/fakeData/");
        String path = url.getPath();

        Assertions.assertThat(repository.load(path))
                .isTrue();
    }
}
