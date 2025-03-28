package com.tavant.hibernate.HibernateCrudWithEntityManager.dao;

import java.util.List;

import com.tavant.hibernate.HibernateCrudWithEntityManager.entity.Movies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Class for the persistence method calls
 */
public class MoviesDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
	
	public void saveMovieDetails(Movies movie) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Movies> listAllMovies() {
		EntityManager em = emf.createEntityManager();
		
		List<Movies> movies = em.createQuery("from Movies", Movies.class).getResultList();
		em.close();
		return movies;
	}
	
	public Movies getMovieById(Integer id) throws Exception {
		EntityManager em = emf.createEntityManager();
		Movies movie = em.find(Movies.class, id);
		
		if (movie == null) {
			throw new Exception("Movie with Id: " + id + " not found");
		}
//		TypedQuery<Movies> query = 
//				em.createQuery("select m from Movies m where m.id = " + id, Movies.class);
//		Movies movie = query.getSingleResult();
 		em.close();
		return movie;
	}
	
    public void updateMovie(Movies movie) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(movie);
        em.getTransaction().commit();
        em.close();
    }
    
    public void deleteMovie(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Movies movie = em.find(Movies.class, id);
        if (movie != null) {
            em.remove(movie);
        }
        em.getTransaction().commit();
        em.close();
    }
}
