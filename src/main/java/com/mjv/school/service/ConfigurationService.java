package com.mjv.school.service;

import com.mjv.school.builder.ConfigurationMapper;
import com.mjv.school.dto.ConfigurationDTO;
import com.mjv.school.model.Configuration;
import com.mjv.school.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    private final ConfigurationMapper configurationMapper;

    public ConfigurationService(ConfigurationRepository configurationRepository, ConfigurationMapper configurationMapper) {
        this.configurationRepository = configurationRepository;
        this.configurationMapper = configurationMapper;
    }

    public List<ConfigurationDTO> findAllConfigurations() {
        return configurationMapper.toListDTO(configurationRepository.findAll());
    }

    public ConfigurationDTO findConfigurationById(Long id) throws Exception {
        return configurationMapper.toDTO(configurationRepository.findById(id).orElseThrow(Exception::new));
    }

    public ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO) {
        return configurationMapper.toDTO(configurationRepository.save(configurationMapper.toEntity(configurationDTO)));
    }

    public void deleteConfigurationById(Long id) {
        configurationRepository.deleteById(id);
    }

    public Configuration updateConfiguration(Configuration configuration) {
        Optional<Configuration> configurationController = configurationRepository.findById(configuration.getId());
        return configurationRepository.save(configurationController.get());
    }

}
