package service;

import builder.ConfigurationMapper;
import dto.ConfigurationDTO;
import model.Configuration;
import org.springframework.stereotype.Service;
import repository.ConfigurationRepository;

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
