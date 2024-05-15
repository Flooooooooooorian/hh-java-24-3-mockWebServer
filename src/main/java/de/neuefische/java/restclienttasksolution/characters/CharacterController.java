package de.neuefische.java.restclienttasksolution.characters;

import de.neuefische.java.restclienttasksolution.characters.api.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final RickMortyApiService rickMortyApiService;

    public CharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping
    public List<RickMortyApiCharacter> getAllCharacters() {
        return rickMortyApiService.loadAllCharacters().results();
    }

    @GetMapping("{id}")
    public  RickMortyApiCharacter getCharacterById(@PathVariable String id){
        return rickMortyApiService.loadCharacterById(id);
    }
}
