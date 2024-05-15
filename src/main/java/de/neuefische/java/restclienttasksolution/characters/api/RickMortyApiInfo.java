package de.neuefische.java.restclienttasksolution.characters.api;

public record RickMortyApiInfo(
        int count,
        int pages,
        String next,
        String prev
) {
}
