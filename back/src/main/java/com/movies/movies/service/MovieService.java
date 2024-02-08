package com.movies.movies.service;

import com.movies.movies.model.Movie;
import com.movies.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Page<Movie> moviePage (Pageable pageable){ return repository.findAll(pageable);}

    public Movie insertMovie (Movie movie){ return repository.save(movie);}
}
