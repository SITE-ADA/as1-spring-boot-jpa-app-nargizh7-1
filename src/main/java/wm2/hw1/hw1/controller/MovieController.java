package wm2.hw1.hw1.controller;

import org.springframework.data.domain.Page;
import wm2.hw1.hw1.model.Director;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.service.DirectorService;
import wm2.hw1.hw1.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movie")
public class MovieController {
    static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;
    private final DirectorService directorService;

    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }
    @GetMapping({"", "/", "/list"})
    public String getMovies(Model model,
                            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                            @RequestParam(name = "sortField", defaultValue = "name") String sortField,
                            @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
                            @RequestParam(name = "filterField", defaultValue = "") String filterField,
                            @RequestParam(name = "filterValue", defaultValue = "") String filterValue) {
        Page<Movie> moviesPage = movieService.list(pageNo, sortField, sortDir, filterField, filterValue);
        model.addAttribute("movies", moviesPage.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", moviesPage.getTotalPages());
        model.addAttribute("nbElements", moviesPage.getNumberOfElements());
        model.addAttribute("totalElements", moviesPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("filterField", filterField);
        model.addAttribute("filterValue", filterValue);

        return "movies/index";
    }

    @GetMapping("/new")
    public String createNewMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("allDirectors", directorService.getAllDirectors()); // Assuming you have a method to get all directors
        return "movies/new";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/movie/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateMovie(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("movies/update");

        mv.addObject("movie", movieService.getById(id));
        return mv;
    }

    @GetMapping("/filter/{keyword}")
    public String getWebMovies(Model model, @PathVariable String keyword) {
        model.addAttribute("movies", movieService.getAllWebMovies(keyword));

        return "movies/index";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("movie") Movie movie, @RequestParam(required = false) List<Long> directors) {
        if (directors != null) {
            movie.setDirectors(directors.stream().map(id -> new Director(id)).collect(Collectors.toSet()));
        }
        movieService.save(movie);
        return "redirect:/movie/";
    }


}
