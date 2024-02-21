package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ThemeService;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    ThemeService themeService;

}
