package co.istad.demowebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VariableUrlController {

    // handle path variable
    @GetMapping("/course/{id}/{slug}")
    public String variable(@PathVariable Integer id, @PathVariable String slug, ModelMap modelMap) {
        System.out.println("Variable: " + id);
        modelMap.addAttribute("keyId", id);
        modelMap.addAttribute("keySlug", slug);
        return "index";
    }

    @GetMapping("/course")
    public String searchCourse(@RequestParam String level,
                               @RequestParam("keyword") String title,
                               Model model) {
        model.addAttribute("keyword", title);
        model.addAttribute("level", level);
        return "search";
    }

}
