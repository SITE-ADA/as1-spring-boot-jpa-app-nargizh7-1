package wm2.hw1.hw1.controller;

import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.model.Director;
import wm2.hw1.hw1.service.MovieService;
import wm2.hw1.hw1.service.DirectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/director")
public class DirectorController {
    static final Logger LOGGER = LoggerFactory.getLogger(DirectorController.class);

    DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping({"", "/", "/list"})
    public String getDirectors(Model model,
                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "sortField", defaultValue = "firstName") String sortField,
                               @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
                               @RequestParam(name = "filterField", defaultValue = "") String filterField,
                               @RequestParam(name = "filterValue", defaultValue = "") String filterValue) {
        Page<Director> directorsPage = directorService.list(pageNo, sortField, sortDir, filterField, filterValue);
        model.addAttribute("directors", directorsPage.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", directorsPage.getTotalPages());
        model.addAttribute("nbElements", directorsPage.getNumberOfElements());
        model.addAttribute("totalElements", directorsPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("filterField", filterField);
        model.addAttribute("filterValue", filterValue);

        return "directors/index";
    }

    @GetMapping("/new")
    public String createNewDirector(Model model) {
        model.addAttribute("director", new Director());
        return "directors/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("director") Director director) {
        directorService.save(director);
        return "redirect:/director/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        directorService.deleteById(id);
        return "redirect:/director/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateDirector(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("directors/update");
        mv.addObject("director", directorService.getById(id));
        return mv;
    }

    @GetMapping("/and/{firstName}/{lastName}")
    public String getDirectorByNameAnd(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        var director = directorService.getDirectorByNamesAnd(firstName, lastName);
        model.addAttribute("directors", director);
        return "directors/index";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getDirectorByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        model.addAttribute("directors", directorService.getDirectorByNamesOr(firstName, lastName));
        return "directors/index";
    }

    @GetMapping("/{id}/movies")
    public String getMoviesByDirectorId(Model model, @PathVariable Long id) {
        model.addAttribute("movies", directorService.getMoviesByDirectorId(id));
        return "movies/index";
    }

    @GetMapping("/{id}/addMovie")
    public String addMoviePage(Model model, @PathVariable Long id) {
        Director stud = directorService.getById(id);
        model.addAttribute("director", stud);
        List<Movie> allMovies = directorService.getMoviesByDirectorIdNot(id);
        model.addAttribute("movies", allMovies);
        return "directors/add_movie";
    }
}
