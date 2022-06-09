package ru.kinorium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParamsTest extends TestBase {

    @Disabled("SimpleTest disabled")
    @DisplayName("Проверка, что 10 > 5")
    @Test
    void SimpleTest() {
        Assertions.assertTrue(10 > 5);
    }

    @ValueSource(strings = {"The Shawshank Redemption", "The Green Mile", "Forrest Gump",
            "Pulp Fiction", "Back to the Future", "Fight Club"})
    @ParameterizedTest(name = "Кинориум, при переходе из ТОП-500, через поиск фильма {0} в результатах есть поле Movies")
    void ValueTest(String testData) {
        kinoPage.openPage()
        .topMenuClick()
        .topMenuSearch(testData)
        .titleMovieResult("Movies");
    }

    // @CsvFileSource(resources = "test_data/films.csv")
    @CsvSource(value = {
            "The Green Mile, Drama",
            "Inception , Action",
            "Pulp Fiction, Thriller",
            "Fight Club, Drama"
    })
    @ParameterizedTest(name = "Кинориум, при переходе из ТОП-500, через поиск фильма {0} в результатах есть поле жанр {1}")
    void CsvTest(String searchData, String expectedResult) {
        kinoPage.openPage()
        .topMenuClick()
        .topMenuSearch(searchData)
        .genreListResult(expectedResult);
    }

    static Stream<Arguments> complexDataProvider() {
        return Stream.of(
                Arguments.of("Inception"),
                Arguments.of("Pulp Fiction")
        );
    }

    @MethodSource(value = "complexDataProvider")
    @ParameterizedTest(name = "Кинориум, при переходе из ТОП-500, через поиск фильма {0} в результатах есть поле жанр Movies")
    void MethodTest(String searchData) {
        kinoPage.openPage()
        .topMenuClick()
        .topMenuSearch(searchData)
        .titleMovieResult("Movies");
    }

    @EnumSource(Movies.class)
    @ParameterizedTest()
    void EnumTest(Movies movies) {
        kinoPage.openPage()
        .topMenuClick()
        .topMenuSearch(movies.desc)
        .titleMovieResult("Movies");

    }
}
