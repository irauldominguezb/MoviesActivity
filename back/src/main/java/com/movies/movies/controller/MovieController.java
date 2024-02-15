package com.movies.movies.controller;

import com.movies.movies.controller.dtoMovie.DtoDates;
import com.movies.movies.model.Movie;
import com.movies.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/page")
    Page<Movie> getPage(Pageable pageable){return service.moviePage(pageable);}

    @GetMapping("/page/name/{name}")
    Page<Movie> getPageByName(@PathVariable(name = "name") String name, Pageable pageable){
        return service.moviePageByName(name, pageable);
    }

    @GetMapping("/page/director/{name}")
    Page<Movie> getPageByDirector(@PathVariable(name = "name") String name, Pageable pageable){
        return service.moviePageByDirector(name, pageable);
    }

    @GetMapping("/page/gender/{name}")
    Page<Movie> getPageByGender(@PathVariable(name = "name") String name, Pageable pageable){
        return service.moviePageByGender(name, pageable);
    }

    @PostMapping("/page/betweenDates")
    Page<Movie> getPageBetweenTwoDates(@Validated @RequestBody DtoDates dates, Pageable pageable){
        return service.moviePageBetweenTwoDates(dates.getStart(), dates.getEnd(), pageable);
    }

    @PostMapping("/page/publication")
    Page<Movie> getPageByPublication(@Validated @RequestBody DtoDates dates, Pageable pageable){
        return service.moviePageByPublication(dates.getStart(), pageable);
    }

    @PostMapping("/")
    Movie insertMovie(@RequestBody( required = true) Movie movie){
        return service.insertMovie(movie);
    }

    @DeleteMapping("/{id}")
    boolean changeStatus(@PathVariable(name = "id") Long id){
        return service.changeStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteMovie(@PathVariable(name = "id") Long id){
        return service.deleteMovie(id);
    }
}
