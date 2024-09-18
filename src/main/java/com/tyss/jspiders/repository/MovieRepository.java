package com.tyss.jspiders.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tyss.jspiders.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Optional<Movie> findByTitle(String title);

	@Query("SELECT m FROM Movie m WHERE imdbRating IS NOT NULL")
	List<Movie> findMovieWithImdbNotNull();

	@Query("SELECT m FROM Movie m WHERE m.studio = :studio")
	List<Movie> findMovieBasedOnStudio(@Param("studio") String studio);

	@Query("SELECT m FROM Movie m WHERE m.releaseYear= :releaseYear")
	List<Movie> findMovieBasenOnReleaseYear(@Param("releaseYear") Integer releaseYear);

	@Query("SELECT COUNT(m) FROM Movie m WHERE m.imdbRating BETWEEN :start AND :end")
	Integer findMovieBasedOnImdbInRange(@Param("start") Integer start,@Param("end") Integer end);

	@Query("SELECT m FROM Movie m WHERE m.industry = 'Bollywood' ORDER BY m.imdbRating DESC LIMIT :num")
	List<Movie> findTopMostMovie(@Param("num") Integer num);

}
