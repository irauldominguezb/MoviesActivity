package com.movies.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
}
