package com.mjv.school.controller;

import com.mjv.school.dto.ConfigurationDTO;
import com.mjv.school.model.Configuration;
import com.mjv.school.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    @GetMapping
    public ResponseEntity<List<ConfigurationDTO>> findAllConfigurations(){
        return new ResponseEntity<>(configurationService.findAllConfigurations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigurationDTO> findConfigurationById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(configurationService.findConfigurationById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ConfigurationDTO> saveConfiguration(@RequestBody ConfigurationDTO configurationDTO) {
        return new ResponseEntity<>(configurationService.saveConfiguration(configurationDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteConfigurationById(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Configuration> updateConfiguration(@RequestBody Configuration configuration) {
        return new ResponseEntity<>(configurationService.updateConfiguration(configuration), HttpStatus.OK);
    }

}
