package de.neuefische.java.restclienttasksolution.characters;

import de.neuefische.java.restclienttasksolution.characters.api.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final RickMortyApiService rickMortyApiService;

    public CharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping("characters")
    public List<RickMortyApiCharacter> getAllCharacters(@RequestParam(required = false) String status) {
        if (status == null) {
            return rickMortyApiService.loadAllCharacters().results();
        }
        return rickMortyApiService.loadAllCharactersByStatus(status).results();
    }

    @GetMapping("characters/{id}")
    public  RickMortyApiCharacter getCharacterById(@PathVariable String id){
        return rickMortyApiService.loadCharacterById(id);
    }

    @GetMapping("species-statistic")
    public int getSpeciesStatistics(@RequestParam String species) {
        return rickMortyApiService.loadSpeciesCount(species);
    }
}
