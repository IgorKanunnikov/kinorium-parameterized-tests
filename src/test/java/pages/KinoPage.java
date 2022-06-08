package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class KinoPage {
    SelenideElement topMenu = $(".topMenu__search-wrap"),
            topMenuComplete = $(".topMenu__Search.ui-autocomplete-input"),
            searchPageMovie = $(".search-page__title-movie"),
            searchPageGenre = $(".search-page__genre-list.cut_text");

    public KinoPage openPage() {
        Selenide.open("collections/kinorium/300/");
        return this;
    }

    public KinoPage topMenuClick() {
        topMenu.click();
        return this;
    }

    public KinoPage topMenuSearch(String value) {
        topMenuComplete.setValue(value);
        topMenuComplete.pressEnter();
        return this;
    }

    public KinoPage titleMovieResult(String value) {
        searchPageMovie.shouldHave(text(value));
        return this;
    }

    public KinoPage genreListResult(String value) {
        searchPageGenre.shouldHave(text(value));
        return this;
    }
}
