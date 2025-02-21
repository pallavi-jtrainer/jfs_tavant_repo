package com.tavant.hibernate.HibernateCrudWithEntityManager;

import java.util.List;

import com.tavant.hibernate.HibernateCrudWithEntityManager.dao.MoviesDao;
import com.tavant.hibernate.HibernateCrudWithEntityManager.entity.Movies;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       MoviesDao dao = new MoviesDao();
       
//       Movies movie = new Movies();
//       movie.setMovieName("Max");
//       movie.setReleaseYear(2025);
//       movie.setLanguage("Kannada");
//       dao.saveMovieDetails(movie);
       
       List<Movies> movies = dao.listAllMovies();
       movies.forEach(m -> System.out.println(m.toString()));
       
       Movies m = null;
	try {
		m = dao.getMovieById(2);
		System.out.println(m.toString());
		 m.setLanguage("Telugu");
       dao.updateMovie(m);
       
       System.out.println("After updating -->");
       m = dao.getMovieById(2);
       System.out.println(m.toString());
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
      
      
    }
}
