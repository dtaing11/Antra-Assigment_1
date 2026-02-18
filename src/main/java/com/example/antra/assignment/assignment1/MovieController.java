package com.example.antra.assignment.assignment1;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year
    ) throws InterruptedException, ExecutionException {
        return movieService.fetchAllPages(title, year);
    } 
}
