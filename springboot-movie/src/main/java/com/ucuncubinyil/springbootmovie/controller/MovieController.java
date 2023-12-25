package com.ucuncubinyil.springbootmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucuncubinyil.springbootmovie.entity.Movie;
import com.ucuncubinyil.springbootmovie.service.impl.MovieServiceImpl;



@Controller
public class MovieController {
	
	@Autowired //reflection 
	MovieServiceImpl movieServiceImpl;
	
	
	@GetMapping("/tumfilmlerGelsin")
	public ResponseEntity<List<Movie>> tumFilmleriGetir()
	{
		List<Movie> gelenFilmListesi = movieServiceImpl.getAllMovies();
		return new ResponseEntity<>(gelenFilmListesi,HttpStatus.OK);
	}
	
	
	 
	 @GetMapping("/tumfilmlerGelsin2")
		public ModelAndView getAllTutorials2() {
			List<Movie> liste = movieServiceImpl.getAllMovies();
			ModelAndView model = new ModelAndView("movies");
			model.addObject("movieListesi",liste);
			return model;
		}
	

}
