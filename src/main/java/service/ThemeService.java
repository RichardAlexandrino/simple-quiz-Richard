package service;

import builder.ThemeMapper;
import dto.ThemeDTO;
import model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ThemeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemeMapper themeMapper;

    public List<ThemeDTO> findAllThemes() {
        return themeMapper.toListDTO(themeRepository.findAll());
    }

    public ThemeDTO findThemeById(Long id) throws Exception {
        return themeMapper.toDTO(themeRepository.findById(id).orElseThrow(Exception::new));
    }

    public ThemeDTO saveTheme(ThemeDTO themeDTO) {
        return themeMapper.toDTO(themeRepository.save(themeMapper.toEntity(themeDTO)));
    }

    public void deleteTheme(Theme theme){
        themeRepository.delete(theme);
    }

    public Theme updateTheme(Theme theme) {
        Optional<Theme> themeController = themeRepository.findById(theme.getId());
        return themeRepository.save(themeController.get());
    }

}
