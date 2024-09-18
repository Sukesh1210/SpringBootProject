package com.tyss.jspiders.service;

import java.util.List;

import com.tyss.jspiders.dto.MovieDTO;
import com.tyss.jspiders.response.SuccessResponse;

public interface MovieService {

	String createMovie(MovieDTO movieDTO);

	MovieDTO findMovie(String title);

	MovieDTO updateMovie(String title, MovieDTO movieDTO);

	String deleteMovie(String title);

	List<MovieDTO> findMovieWithImdbNotNull();

	List<MovieDTO> findMovieBasedOnStudio(String studio);

	List<MovieDTO> findMovieBasenOnReleaseYear(Integer releaseYear);

	Integer findMovieBasedOnImdbInRange(Integer start, Integer end);

	List<MovieDTO> findTopMostMovie(Integer num);

}
