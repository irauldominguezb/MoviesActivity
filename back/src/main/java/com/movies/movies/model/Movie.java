package com.movies.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String duration;
    @Column
    private String director;
    @Column
    private Date publication;
    @Column
    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
}
