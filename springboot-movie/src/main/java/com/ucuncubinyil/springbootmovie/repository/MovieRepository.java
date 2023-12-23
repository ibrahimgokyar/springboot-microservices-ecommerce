package com.ucuncubinyil.springbootmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucuncubinyil.springbootmovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
