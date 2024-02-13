package com.movies.movies.service;

import com.movies.movies.model.Movie;
import com.movies.movies.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Page<Movie> moviePage (Pageable pageable){ return repository.findAll(pageable);}

    public Page<Movie> moviePageByName (String name, Pageable pageable){
        return repository.findMoviesByNameContaining(name, pageable);
    }

    public Page<Movie> moviePageByDirector (String name, Pageable pageable){
        return repository.findMoviesByDirectorContaining(name, pageable);
    }

    public Page<Movie> moviePageByGender (String name, Pageable pageable){
        return repository.findMoviesByGender_Name(name, pageable);
    }

    public Page<Movie> moviePageBetweenTwoDates (Date start, Date end, Pageable pageable){
        return repository.findMoviesByPublicationBetween(start, end, pageable);
    }

    public Page<Movie> moviePageByPublication (Date publication, Pageable pageable){
        return repository.findMoviesByPublicationOrderByPublicationDesc(publication, pageable);
    }

    public Movie insertMovie (Movie movie){ return repository.save(movie);}

    @Transactional
    public boolean changeStatus(Long id){
        try{
            Optional<Movie> movie = repository.findById(id);
            repository.updateStatus(!movie.get().isAvailable(), id);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
