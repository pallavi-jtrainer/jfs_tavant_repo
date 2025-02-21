package com.tavant.hibernate.HibernateCrudWithEntityManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length=150)
	private String movieName;
	
	@Column(nullable = false)
	private Integer releaseYear;
	
	@Column(nullable = false)
	private String language;
	
	public Movies() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Movies(int id, String movieName, int releaseYear, String language) {
		this.id = id;
		this.movieName = movieName;
		this.releaseYear = releaseYear;
		this.language = language;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", releaseYear=" + releaseYear + ", language="
				+ language + "]";
	}
	
	
}
