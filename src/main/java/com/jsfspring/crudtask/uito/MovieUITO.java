package com.jsfspring.crudtask.uito;

import java.io.Serializable;
import java.util.List;

public class MovieUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long deptId;
	private String deptName;

	private List<ViewerUITO> viewerUITOLst;

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

	public List<ViewerUITO> getViewerUITOLst() {
		return viewerUITOLst;
	}

	public void setViewerUITOLst(List<ViewerUITO> viewerUITOLst) {
		this.viewerUITOLst = viewerUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieUITO other = (MovieUITO) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		return true;
	}

}
