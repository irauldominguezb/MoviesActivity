package com.movies.movies.service;

import com.movies.movies.model.Gender;
import com.movies.movies.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository repository;

    public List<Gender> genders(){ return repository.findAll();}
}
