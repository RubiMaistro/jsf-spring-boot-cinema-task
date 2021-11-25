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
public class MovieDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Movie_Id")
	private Long movieId;
	@Column(name = "Movie_Name")
	private String MovieName;

	@OneToMany(mappedBy = "movieDTO")
	private List<ViewerDTO> viewerdtolst;

	public Long getDeptId() {
		return movieId;
	}

	public void setDeptId(Long deptId) {
		this.movieId = deptId;
	}

	public String getDeptName() {
		return MovieName;
	}

	public void setDeptName(String deptName) {
		this.MovieName = deptName;
	}

	public List<ViewerDTO> getViewerdtolst() {
		if (null == viewerdtolst) {
			viewerdtolst = new ArrayList<>();
		}
		return viewerdtolst;
	}

	public void setViewerdtolst(List<ViewerDTO> viewerdtolst) {
		this.viewerdtolst = viewerdtolst;
	}
}
