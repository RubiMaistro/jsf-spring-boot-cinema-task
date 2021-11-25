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
	@Column(name = "DEPT_ID")
	private Long deptId;
	@Column(name = "Dept_Name")
	private String deptName;

	@OneToMany(mappedBy = "movieDTO")
	private List<ViewerDTO> viewerdtolst;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
