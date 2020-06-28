package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	@Autowired
	private MovieDaoCollectionImpl moiveDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	private static HashMap<String, Favorites> userFavorites = new HashMap<String, Favorites>();;

	@Override
	public void addFavoritesMovie(String userId, int movieId) {

		LOGGER.info("FavoritesDaoCollectionImpl addFavoritesMovie() START");

		Movie movie = moiveDaoCollectionImpl.findById(movieId);

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			movieFavoritesList.add(movie);
		} else {
			Favorites favorite = new Favorites(userId, new ArrayList<Movie>());
			favorite.getFavoritesMovieList().add(movie);
			userFavorites.put(userId, favorite);
		}

		LOGGER.debug("UserId:{}", userId);
		LOGGER.debug("MovieId: {}", movieId);
		LOGGER.debug("UserFavorites:{}", userFavorites);

		LOGGER.info("FavoritesDaoCollectionImpl addFavoritesMovie() END");

	}

	@Override
	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		LOGGER.info("FavoritesDaoCollectionImpl.getAllFavoritesMovies() START");

		if (userFavorites.containsKey(userId)) {
			double total = 0.0;
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			if (movieFavoritesList.isEmpty()) {
				throw new FavoritesEmptyException();
			}

			LOGGER.debug("UserMovieList: {}", movieFavoritesList);
			LOGGER.debug("UserId: {}", userId);
			LOGGER.info("FavoritesDaoCollectionImpl.getAllFavoritesMovies() END");
			return movieFavoritesList;
		}

		LOGGER.info("FavoritesDaoCollectionImpl.getAllFavoritesMovies() END");
		throw new FavoritesEmptyException();
	}

	@Override
	public void removeFavoritesMovie(String userId, int movieId) {
		LOGGER.info("FavoritesDaoCollectionImpl.removeFavoritesMovie() START");

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();

			for (int i = 0; i < movieFavoritesList.size(); i++) {
				if (movieFavoritesList.get(i).getId() == movieId) {
					movieFavoritesList.remove(i);
				}
			}
			LOGGER.debug("userId: {}", userId);
			LOGGER.debug("movieId: {}", movieId);
			LOGGER.debug("MovieFavoritesList: {}", movieFavoritesList);
			LOGGER.debug("UserFavorites: {}", userFavorites);
			LOGGER.info("FavoritesDaoCollectionImpl.removeFavoritesMovie() END");
		} else {
			LOGGER.info("FavoritesDaoCollectionImpl.removeFavoritesMovie() END");
			throw new FavoritesEmptyException();
		}

	}

}
