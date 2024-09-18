package com.tyss.jspiders.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.jspiders.dto.MovieDTO;
import com.tyss.jspiders.response.SuccessResponse;
import com.tyss.jspiders.service.MovieService;

import lombok.RequiredArgsConstructor;

@Lazy
@RequiredArgsConstructor
@RequestMapping(path = "api/movie")
@RestController
public class MovieController {
	private final MovieService movieService;

//	@GetMapping(path = "dummy")
//	public Object dummy() {
//
//		return MovieDTO.builder().language(LanguageDTO.builder().build()).financial(FinancialDTO.builder().build())
//				.actors(List.<ActorDTO>of(ActorDTO.builder().build())).build();
//
//	}
	
	
//	Create all the CRUD operation APIs for Movie.
//	Construct an API to fetch movies with non-NULL IMDb ratings?
//	Construct an API to display the top X Hollywood movies with the highest IMDb ratings.
//	Construct an API to fetch movies produced by "Some List of Studios" using an API?
//	Construct an API to give the count movies with IMDb ratings between X and Y?
//	Construct an API to fetch movies released in the years X

// CREATE Operation	
	@PostMapping(path = "createMovie")
	public ResponseEntity<SuccessResponse> createMovie(@RequestBody MovieDTO movieDTO) {

		String movieTitle = movieService.createMovie(movieDTO);

		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Created Successfully").data(movieTitle).status(HttpStatus.CREATED)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());

	}

//GET Operation
	@GetMapping(path = "findMovieByTitle")
	public ResponseEntity<SuccessResponse> findMovie(@RequestParam String title) {

		MovieDTO movieDTO = movieService.findMovie(title);

		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Fetch Successfully").data(movieDTO).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());

	}

//UPDATE Operation
	@PutMapping(path = "updateMovie")
	public ResponseEntity<SuccessResponse> updateMovie(@RequestParam String title, @RequestBody MovieDTO movieDTO) {

		MovieDTO updatedMovie = movieService.updateMovie(title, movieDTO);

		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Updated Successfully").data(updatedMovie).status(HttpStatus.OK)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());

	}

// DELETE Operation	
	@DeleteMapping(path = "deleteMovie")
	public ResponseEntity<SuccessResponse> deleteMovie(@RequestParam String title) {

		String deletedMovie = movieService.deleteMovie(title);

		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Deleted Successfully").data(deletedMovie).status(HttpStatus.OK)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());

	}
	
//  An API to fetch movies with non-NULL IMDb ratings?
	@GetMapping(path="imdbNotNull")
	public ResponseEntity<SuccessResponse> findMovieWithImdbNotNull() {
		
		List<MovieDTO> moviesDto = movieService.findMovieWithImdbNotNull();
		
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Fetched Successfully").data(moviesDto).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());
		
	}
	
// An API to fetch movies produced by "Some List of Studios" using an API?
	
	@GetMapping(path="movieBasedOnStudio")
	public ResponseEntity<SuccessResponse> findMovieBasedOnStudio(String studio) {
		
		List<MovieDTO> moviesDto = movieService.findMovieBasedOnStudio(studio);
		
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Fetched Successfully").data(moviesDto).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());
		
	}
	
// An API to fetch movies released in the years X
	
	@GetMapping(path="movieBasenOnReleaseYear")
	public ResponseEntity<SuccessResponse> findMovieBasenOnReleaseYear(@RequestParam Integer releaseYear) {
		
		List<MovieDTO> moviesDto = movieService.findMovieBasenOnReleaseYear(releaseYear);
		
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Fetched Successfully").data(moviesDto).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());
		
	}
	
//An API to give the count movies with IMDb ratings between X and Y?
	
	@GetMapping(path="movieBasedOnImdbInRange")
	public ResponseEntity<SuccessResponse> findMovieBasedOnImdbInRange(@RequestParam Integer start,@RequestParam Integer end) {
		
		Integer count = movieService.findMovieBasedOnImdbInRange(start,end);
		
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Fetched Successfully").data(count).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());
		
	}
	
//An API to display the top X Hollywood movies with the highest IMDb ratings
	
	@GetMapping(path="topMovies")
	public ResponseEntity<SuccessResponse> findTopMostMovie(Integer num) {
		
		List<MovieDTO> movieDto = movieService.findTopMostMovie( num);
		
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Movie Fetched Successfully").data(movieDto).status(HttpStatus.FOUND)
						.token("qweerfgf23432.12343sdfsdfds.1234321123gfdsdf").timeStamp(LocalDateTime.now()).build());
		
	}
	
}
