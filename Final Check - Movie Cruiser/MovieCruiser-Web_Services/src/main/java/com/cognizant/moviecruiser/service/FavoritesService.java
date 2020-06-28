package com.cognizant.moviecruiser.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	@Autowired
	private FavoritesDao favoritesDao;

	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		LOGGER.info("FavoritesService getAllFavoritesMovies() START");
		LOGGER.info("FavoritesService getAllFavoritesMovies() END");
		return favoritesDao.getAllFavoritesMovies(userId);
	}

	public void removeFavoritesMovie(String userId, int movieId) {
		LOGGER.info("FavoritesService removeFavoritesMovie() START");
		favoritesDao.removeFavoritesMovie(userId, movieId);
		LOGGER.info("FavoritesService removeFavoritesMovie() END");
	}

	public void addFavoritesMovie(String userId, int movieId) {
		LOGGER.info("FavoritesService addFavoritesMovie() START");
		favoritesDao.addFavoritesMovie(userId, movieId);
		LOGGER.info("FavoritesService addFavoritesMovie() END");
	}
}
