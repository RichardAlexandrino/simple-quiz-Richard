package controller;

import dto.ThemeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ThemeService;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    ThemeService themeService;

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> findAllThemes(){
        return new ResponseEntity<>(themeService.findAllThemes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDTO> findThemeById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(themeService.findThemeById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ThemeDTO> saveTheme(@RequestBody ThemeDTO themeDTO) {
        return new ResponseEntity<>(themeService.saveTheme(themeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteThemeById(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
