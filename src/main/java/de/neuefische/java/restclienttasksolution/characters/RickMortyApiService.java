package de.neuefische.java.restclienttasksolution.characters;

import de.neuefische.java.restclienttasksolution.characters.api.RickMortyApiCharacter;
import de.neuefische.java.restclienttasksolution.characters.api.RickMortyApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickMortyApiService {

    private final RestClient restClient;

    public RickMortyApiService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://rickandmortyapi.com")
                .build();
    }

    public RickMortyApiResponse loadAllCharacters() {

        RickMortyApiResponse body = restClient.get()
                .uri("/api/character")
                .retrieve()
                .body(RickMortyApiResponse.class);

        return body;
    }

    public RickMortyApiCharacter loadCharacterById(String id) {
        return restClient.get()
                .uri("/api/character/" + id)
                .retrieve()
                .body(RickMortyApiCharacter.class);
    }
}
