package com.jsfspring.crudtask.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "MOVIES")
public class MovieDTO<movieName> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MOVIE_ID")
	private Long movieId;
	@Column(name = "Movie_Name")
	private String movieName;

	@OneToMany(mappedBy = "movieDTO")
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
