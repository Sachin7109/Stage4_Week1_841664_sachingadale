package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoCollectionImpl implements MovieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
	private ArrayList<Movie> adminMovieList = context.getBean("adminMovieList", ArrayList.class);
	private ArrayList<Movie> userMovieList = context.getBean("userMovieList", ArrayList.class);

	@Override
	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieDaoCollectionImpl.getMovieListAdmin() START");

		LOGGER.debug("AdminMovieList: {}", adminMovieList);

		LOGGER.info("MovieDaoCollectionImpl.getMovieListAdmin() END");
		return adminMovieList;
	}

	@Override
	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieDaoCollectionImpl.getMovieListCustomer() START");

		LOGGER.debug("UserMovieList: {}", userMovieList);

		LOGGER.info("MovieDaoCollectionImpl.getMovieListCustomer() END");
		return userMovieList;
	}

	@Override
	public Movie findById(int id) {
		LOGGER.info("MovieDaoCollectionImpl.findById() START");

		LOGGER.info("MovieDaoCollectionImpl.findById() END");

		return adminMovieList.stream().filter(movie -> movie.getId() == id).findFirst().orElseThrow(() -> {
			throw new MovieNotFoundException();
		});
	}

	@Override
	public void modifyMovie(Movie movie) {
		LOGGER.info("MovieDaoCollectionImpl.modifyMovie() START");

		Movie movieUpdate = findById(movie.getId());

		movieUpdate.setTitle(movie.getTitle());
		movieUpdate.setBoxOffice(movie.getBoxOffice());
		movieUpdate.setBoxOffice(movie.getBoxOffice());
		movieUpdate.setActive(movie.isActive());
		movieUpdate.setDateOfLaunch(movie.getDateOfLaunch());
		movieUpdate.setGenre(movie.getGenre());
		movieUpdate.setHasTeaser(movie.isHasTeaser());
		movieUpdate.setLink(movie.getLink());

		LOGGER.debug("MovieUpdate: {}", movieUpdate);
		LOGGER.info("MovieDaoCollectionImpl.modifyMovie() END");
	}

	@Override
	public ArrayList<Movie> getMovieListActive() {
		
		LOGGER.info("MovieDaoCollectionImpl.getMovieListActive() START");

		ArrayList<Movie> activeMovieList = new ArrayList<Movie>();

		for (Movie movie : adminMovieList) {
			if(movie.isActive())
				activeMovieList.add(movie);
		}
		
		LOGGER.debug("ActiveMovieUpdate: {}", activeMovieList);
		LOGGER.info("MovieDaoCollectionImpl.getMovieListActive() END");
		return activeMovieList;
	}
}
