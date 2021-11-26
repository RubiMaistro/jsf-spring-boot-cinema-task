package com.jsfspring.crudtask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "VIEWER_INFO")
@NamedQuery(name = "ViewerDTO.findAll", query = "SELECT a FROM ViewerDTO a")
public class ViewerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long viewerId;
	@Column(name = "VIEWER_NAME", nullable = false)
	private String viewerName;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "ID_ADDRESS", nullable = false)
	private String address1;
	@Column(name = "EMAIL_ID")
	private String emailId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID")
	private MovieDTO movieDTO;

	public Long getViewerId() {
		return viewerId;
	}

	public void setViewerId(Long viewerId) {
		this.viewerId = viewerId;
	}

	public String getViewerName() {
		return viewerName;
	}

	public void setViewerName(String viewerName) {
		this.viewerName = viewerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public MovieDTO getMovieDTO() {

		return movieDTO;
	}

	public void setMovieDTO(MovieDTO movieDTO) {
		this.movieDTO = movieDTO;
	}

}
