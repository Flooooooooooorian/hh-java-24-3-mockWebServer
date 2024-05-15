package de.neuefische.java.restclienttasksolution.characters;

import de.neuefische.java.restclienttasksolution.characters.api.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final RickMortyApiService rickMortyApiService;

    public CharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping
    public List<RickMortyApiCharacter> getAllCharacters(@RequestParam(required = false) String status) {
        if (status == null) {
            return rickMortyApiService.loadAllCharacters().results();
        }
        return rickMortyApiService.loadAllCharactersByStatus(status).results();
    }

    @GetMapping("{id}")
    public  RickMortyApiCharacter getCharacterById(@PathVariable String id){
        return rickMortyApiService.loadCharacterById(id);
    }
}
