package com.movies.movies.modules.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.movies.config.ResponseApi;
import com.movies.movies.modules.movie.model.DtoDates;
import com.movies.movies.modules.movie.model.DtoMovie;
import com.movies.movies.modules.movie.model.Movie;
import com.movies.movies.security.service.CryptService;
import jakarta.validation.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movie")
@CrossOrigin(origins = {"*"})
public class MovieController {

    private final CryptService cryptService;
    private final MovieService service;
    ObjectMapper objectMapper;

    @GetMapping("/page/")
    ResponseApi<?> getPage(Pageable pageable){
        try{
            Page<Movie> page = service.moviePage(pageable);
            String crypt = cryptService.encrypt(objectMapper.writeValueAsString(page));
            return new ResponseApi<>(crypt, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseApi<>(null, HttpStatus.INTERNAL_SERVER_ERROR, true, "internal server error");
        }

    }

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
    Page<Movie> getPageBetweenTwoDates(@Valid @RequestBody DtoDates dates, Pageable pageable){
        return service.moviePageBetweenTwoDates(dates.getStart(), dates.getEnd(), pageable);
    }

    @PostMapping("/page/publication")
    Page<Movie> getPageByPublication(@Valid @RequestBody DtoDates dates, Pageable pageable){
        return service.moviePageByPublication(dates.getStart(), pageable);
    }

    @PostMapping("/")
    ResponseApi<?> insertMovie(@RequestBody String data) {
        try {
            String movieString = cryptService.decrypt(data);

            DtoMovie movie = objectMapper.readValue(movieString, DtoMovie.class);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<DtoMovie>> violations = validator.validate(movie);

            if (!violations.isEmpty()) {
                Map<String, String> validationErrors = new HashMap<>();
                violations.forEach(violation -> validationErrors.put(violation.getPropertyPath() + "", violation.getMessage()));
                return new ResponseApi<>(null, HttpStatus.BAD_REQUEST, true, "bad request", validationErrors);
            }
            return new ResponseApi<>(service.insertMovie(movie), HttpStatus.OK);
        }catch (JsonProcessingException ex){
            return new ResponseApi<>(null, HttpStatus.BAD_REQUEST, true, "malformed request");
        } catch (Exception ex) {
            return new ResponseApi<>(null, HttpStatus.BAD_REQUEST, true, "failed crypt service");
        }
    }

    @DeleteMapping("/{id}")
    boolean changeStatus(@PathVariable(name = "id") Long id){
        return service.changeStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteMovie(@PathVariable(name = "id") Long id){
        return service.deleteMovie(id);
    }


    void validMovie (@Valid DtoMovie movie){}
}
