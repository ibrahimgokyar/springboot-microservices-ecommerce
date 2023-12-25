package com.ucuncubinyil.springbootmovie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucuncubinyil.springbootmovie.entity.Movie;
import com.ucuncubinyil.springbootmovie.repository.MovieRepository;
import com.ucuncubinyil.springbootmovie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	//tüm filmleri getirecek olan service
	@Override
	public List<Movie> getAllMovies() {
		//select * from Movie
		List<Movie> movieList = movieRepository.findAll();
		return movieList;
	}

	@Override
	public Movie movieDetail(long id) {
		//select * from Movie where id=id
		Movie movieDetail = movieRepository.getOne(id);
		return movieDetail;
	}

	//{"title":"movie1","description":"movie1 desc"}
	@Override
	public Movie create(Movie movie) {
		//insert into Movie(title,description) values(movie.title,movie.description);
		Movie insertedMovie = movieRepository.save(movie);
		return insertedMovie;
	}

	@Override
	public Movie update(Movie movie) {
		Movie guncellencekMovie = movieRepository.getOne(movie.getId());
		guncellencekMovie.setTitle(movie.getTitle());
		guncellencekMovie.setDescription(movie.getDescription());
		guncellencekMovie.setImageurl(movie.getImageurl());
		Movie guncellenmisMovie = movieRepository.save(guncellencekMovie);
		return guncellenmisMovie;
	}

	@Override
	public Boolean delete(long id) {
		boolean isDeleted=false; //flag
		try
		{
			movieRepository.deleteById(id);
			isDeleted = true;
		}
		catch(Exception ex)
		{
			isDeleted = false;
		}
		return isDeleted;
	}

}
