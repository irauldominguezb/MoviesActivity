package com.movies.movies.controller;

import com.movies.movies.model.Movie;
import com.movies.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie/")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/page")
    Page<Movie> getPage(Pageable pageable){return service.moviePage(pageable);}

    @PostMapping("/")
    Movie insertMovie(@RequestBody( required = true) Movie movie){
        return service.insertMovie(movie);
    }
}
