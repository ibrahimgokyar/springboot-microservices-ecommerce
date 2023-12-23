package com.ucuncubinyil.springbootmovie.service;

import java.util.List;

import com.ucuncubinyil.springbootmovie.entity.Movie;

public interface MovieService {
	
	
	List<Movie> getAllMovies();
	
	Movie movieDetail(long id);
	
	Movie create(Movie movie);
	
	Movie update(Movie movie);
	
	Boolean delete(long id);

}
