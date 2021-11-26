package com.jsfspring.crudtask.entity;

import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "MOVIES")
@NamedQuery(name = "MovieDTO.findAll", query = "SELECT a FROM MovieDTO a")
public class MovieDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private Long movieId;
	@Column(name = "MOVIE_NAME")
	private String movieName;

	@OneToMany(fetch =  FetchType.LAZY)
	private List<ViewerDTO> viewerdtolst;

	public Long getMovieId() { return movieId; }

	public void setMovieId(Long movieId) { this.movieId = movieId; }

	public String getMovieName() { return movieName; }

	public void setMovieName(String movieName) { this.movieName = movieName; }

	public void setViewerdtolst(List<ViewerDTO> viewerdtolst) { this.viewerdtolst = viewerdtolst; }

	public List<ViewerDTO> getViewerdtolst() {
		if (null == viewerdtolst) {
			viewerdtolst = new ArrayList<>();
		}
		return viewerdtolst;
	}

}
