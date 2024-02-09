package com.movies.movies.repository;

import com.movies.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Modifying
    @Query("update Movie SET available = :available where id = :id")
    void updateStatus (@Param("available") boolean available, @Param("id") Long id);
}
