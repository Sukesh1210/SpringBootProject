package com.tyss.jspiders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tyss.jspiders.dto.ActorDTO;
import com.tyss.jspiders.dto.MovieDTO;
import com.tyss.jspiders.entity.Movie;
import com.tyss.jspiders.exception.MovieNotFoundException;
import com.tyss.jspiders.repository.MovieRepository;
import com.tyss.jspiders.utils.MovieUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
	private final MovieRepository movieRepository;

	@Override
	public String createMovie(MovieDTO movieDTO) {
		Movie movie = MovieUtils.movieDtoToMovie(movieDTO);

		return movieRepository.save(movie).getTitle();
	}

	@Override
	public MovieDTO findMovie(String title) {
		Movie movie = movieRepository.findByTitle(title)
				.orElseThrow(() -> new MovieNotFoundException("Movie With given Title Not Found"));

		MovieDTO movieDTO = MovieUtils.movieToMovieDto(movie);

		return movieDTO;
	}

	@Override
	public MovieDTO updateMovie(String title, MovieDTO movieDTO) {
		Movie movie = movieRepository.findByTitle(title)
				.orElseThrow(() -> new MovieNotFoundException("Movie With given Title Not Found"));

		movie.setTitle(movieDTO.getTitle());
		movie.setIndustry(movieDTO.getIndustry());
		movie.setImdbRating(movieDTO.getImdbRating());
		movie.setReleaseYear(movieDTO.getReleaseyear());
		movie.setStudio(movieDTO.getStudio());

		movie.getLanguage().setName(movieDTO.getLanguage().getName());

		movie.getFinancial().setBudget(movieDTO.getFinancial().getBudget());
		movie.getFinancial().setCurrency(movieDTO.getFinancial().getCurrency());
		movie.getFinancial().setRevenue(movieDTO.getFinancial().getRevenue());
		movie.getFinancial().setUnit(movieDTO.getFinancial().getUnit());

		Movie movie2 = movieRepository.save(movie);

		return MovieUtils.movieToMovieDto(movie2);
	}

	@Override
	public String deleteMovie(String title) {
		Movie movie = movieRepository.findByTitle(title)
				.orElseThrow(() -> new MovieNotFoundException("Movie With given Title Not Found"));
		String deletedtitle = movie.getTitle();
		movieRepository.delete(movie);
		return deletedtitle;
	}

	@Override
	public List<MovieDTO> findMovieWithImdbNotNull() {

		List<Movie> movies = movieRepository.findMovieWithImdbNotNull();

		List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

		for (Movie movie : movies) {
			movieDTOs.add(MovieUtils.movieToMovieDto(movie));
		}

		return movieDTOs;
	}

	@Override
	public List<MovieDTO> findMovieBasedOnStudio(String studio) {

		List<Movie> movies = movieRepository.findMovieBasedOnStudio(studio);

		List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

		for (Movie movie : movies) {
			movieDTOs.add(MovieUtils.movieToMovieDto(movie));
		}

		return movieDTOs;
	}

	@Override
	public List<MovieDTO> findMovieBasenOnReleaseYear(Integer releaseYear) {

		List<Movie> movies = movieRepository.findMovieBasenOnReleaseYear(releaseYear);

		List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

		for (Movie movie : movies) {
			movieDTOs.add(MovieUtils.movieToMovieDto(movie));
		}

		return movieDTOs;
	}

	@Override
	public Integer findMovieBasedOnImdbInRange(Integer start, Integer end) {

		Integer count = movieRepository.findMovieBasedOnImdbInRange(start, end);

		return count;
	}

	@Override
	public List<MovieDTO> findTopMostMovie(Integer num) {
		List<Movie> movies = movieRepository.findTopMostMovie(num);
		
		List<MovieDTO> movieDTOs= new ArrayList<MovieDTO>();
		
		for (Movie movie : movies) {
			movieDTOs.add(MovieUtils.movieToMovieDto(movie));
		}
		return movieDTOs;
	}

}
