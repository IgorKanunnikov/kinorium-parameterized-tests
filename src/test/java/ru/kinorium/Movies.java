package ru.kinorium;

public enum Movies {
    NEW("Inception"),
    OLD("Fight Club");

    public final String desc;

    Movies(String desc) {
        this.desc = desc;
    }
}
