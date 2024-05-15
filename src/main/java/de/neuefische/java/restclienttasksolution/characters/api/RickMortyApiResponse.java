package de.neuefische.java.restclienttasksolution.characters.api;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record RickMortyApiResponse(
        RickMortyApiInfo info,
        List<RickMortyApiCharacter> results
) {
}
