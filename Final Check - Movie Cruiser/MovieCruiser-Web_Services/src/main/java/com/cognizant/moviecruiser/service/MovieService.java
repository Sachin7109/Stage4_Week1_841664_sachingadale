package com.cognizant.moviecruiser.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	@Autowired
	private MovieDao movieDao;

	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieService.getMovieListAdmin() START");

		LOGGER.info("MovieService.getMovieListAdmin() END");
		return movieDao.getMovieListAdmin();
	}

	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieService.getMovieListAdmin() START");

		LOGGER.info("MovieService.getMovieListAdmin() END");
		return movieDao.getMovieListCustomer();
	}

	public void modifyMovie(Movie movie) {
		LOGGER.info("MovieService.modifyMovie() START");

		movieDao.modifyMovie(movie);
		LOGGER.info("MovieService.modifyMovie() END");
	}

	public ArrayList<Movie> getMovieListActive() {
		LOGGER.info("MovieService.getMovieListActive() START");

		LOGGER.info("MovieService.getMovieListActive() END");
		return movieDao.getMovieListActive();
	}
}