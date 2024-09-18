package com.tyss.jspiders.utils;

import java.util.ArrayList;
import java.util.List;

import com.tyss.jspiders.dto.ActorDTO;
import com.tyss.jspiders.dto.FinancialDTO;
import com.tyss.jspiders.dto.LanguageDTO;
import com.tyss.jspiders.dto.MovieDTO;
import com.tyss.jspiders.entity.Actor;
import com.tyss.jspiders.entity.Financial;
import com.tyss.jspiders.entity.Language;
import com.tyss.jspiders.entity.Movie;

public interface MovieUtils {

	static Movie movieDtoToMovie(MovieDTO movieDTO) {
		Movie movie = Movie.builder().title(movieDTO.getTitle()).industry(movieDTO.getIndustry())
				.imdbRating(movieDTO.getImdbRating()).releaseYear(movieDTO.getReleaseyear())
				.studio(movieDTO.getStudio())
				.language(Language.builder().name(movieDTO.getLanguage().getName()).build())
				.financial(Financial.builder().budget(movieDTO.getFinancial().getBudget())
						.revenue(movieDTO.getFinancial().getRevenue()).currency(movieDTO.getFinancial().getCurrency())
						.unit(movieDTO.getFinancial().getUnit()).build())
				.build();

		List<Actor> actors = new ArrayList<Actor>();

		for (ActorDTO actorDTO : movieDTO.getActors()) {
			actors.add(Actor.builder().name(actorDTO.getName()).birthyear(actorDTO.getBirthyear()).build());
		}

		movie.setActors(actors);
		return movie;

	}

	static MovieDTO movieToMovieDto(Movie movie) {

		MovieDTO movieDTO = MovieDTO.builder().title(movie.getTitle()).industry(movie.getIndustry())
				.imdbRating(movie.getImdbRating()).studio(movie.getStudio())
				.language(LanguageDTO.builder().name(movie.getLanguage().getName()).build())
				.financial(FinancialDTO.builder().budget(movie.getFinancial().getBudget())
						.revenue(movie.getFinancial().getRevenue()).currency(movie.getFinancial().getCurrency())
						.unit(movie.getFinancial().getUnit()).build())
				.build();

		List<ActorDTO> actorDTOs = new ArrayList<ActorDTO>();

		for (Actor actor : movie.getActors()) {
			actorDTOs.add(ActorDTO.builder().name(actor.getName()).birthyear(actor.getBirthyear()).build());
		}

		movieDTO.setActors(actorDTOs);
		return movieDTO;

	}

	

}
