package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieCruiserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	@Autowired
	private MovieService movieService;

	@Autowired
	private FavoritesService favoritesService;

	@GetMapping("/adminlist")
	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieCruiserController.getMovieListAdmin() START");

		LOGGER.info("MovieCruiserController.getMovieListAdmin() END");
		return movieService.getMovieListAdmin();
	}

	@GetMapping("/userlist")
	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieCruiserController.getMovieListAdmin() START");

		LOGGER.info("MovieCruiserController.getMovieListAdmin() END");
		return movieService.getMovieListCustomer();
	}

	@PutMapping("/adminmodify")
	public void modifyMovie(@RequestBody Movie movie) {
		LOGGER.info("MovieCruiserController.modifyMovie() START");

		movieService.modifyMovie(movie);

		LOGGER.info("MovieCruiserController.modifyMovie() END");
	}

	@PostMapping("/{userId}/{movieId}")
	public void addFavoritesMovie(@PathVariable @Valid String userId, @PathVariable @Valid int movieId) {
		LOGGER.info("MovieCruiserController.addFavoritesMovie() START");
		favoritesService.addFavoritesMovie(userId, movieId);
		LOGGER.info("MovieCruiserController.addFavoritesMovie() END");

	}

	@GetMapping("/favorites/{userId}")
	public ArrayList<Movie> getAllFavoritesMovies(@PathVariable @Valid String userId) {
		LOGGER.info("MovieCruiserController.getAllFavoritesMovies() START");

		LOGGER.info("MovieCruiserController.getAllFavoritesMovies() END");
		return favoritesService.getAllFavoritesMovies(userId);
	}

	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavoritesMovie(@PathVariable @Valid String userId, @PathVariable @Valid int movieId) {
		LOGGER.info("MovieCruiserController.removeFavoritesMovie() START");
		favoritesService.removeFavoritesMovie(userId, movieId);
		LOGGER.info("MovieCruiserController.removeFavoritesMovie() END");

	}

	@GetMapping("/active")
	public ArrayList<Movie> getMovieListActive() {
		LOGGER.info("MovieCruiserController.getMovieListActive() START");

		LOGGER.info("MovieCruiserController.getMovieListActive() END");
		return movieService.getMovieListActive();
	}

}