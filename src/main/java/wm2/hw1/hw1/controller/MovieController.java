package wm2.hw1.hw1.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import wm2.hw1.hw1.model.Movie;
import wm2.hw1.hw1.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Qualifier
    private MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;
    }

    @GetMapping({"", "/", "/list"})
    public String getMovies(Model model) {
        List<Movie> movies = movieService.list();
        model.addAttribute("movies", movies);

        LOGGER.info(movies.toString());

        return "movies/index";
    }

    @GetMapping("/new")
    public String createNewMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movie/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("movie", movieService.getById(id));
        return "movies/info";
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
}
