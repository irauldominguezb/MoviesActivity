package com.movies.movies.controller;

import com.movies.movies.model.Gender;
import com.movies.movies.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gender")
@CrossOrigin(origins = "*")
public class GenderController {

    @Autowired
    private GenderService service;

    @GetMapping("/")
    List<Gender> findGenders (){ return service.genders();}
}
