package de.neuefische.java.restclienttasksolution.characters.api;

import java.util.List;

public record RickMortyApiCharacter(
        int id,
        String name,
        String status,
        String species,
        List<String> episode) {
}
