/**
 * 
 */
package com.jsfspring.crudtask.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class ViewerUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long viewerId;
	private String viewerName;
	private String password;
	private String address1;
	private String emailId;
	private MovieUITO movieUITO;

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

	public MovieUITO getMovieUITO() {
		return movieUITO;
	}

	public void setMovieUITO(MovieUITO movieUITO) {
		this.movieUITO = movieUITO;
	}

	@Override
	public String toString() {
		return "ViewerUITO [viewerId=" + viewerId + ", viewerName=" + viewerName + ", password=" + password + ", address1="
				+ address1 + ", emailId=" + emailId + ", movieUITO=" + movieUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((viewerName == null) ? 0 : viewerName.hashCode());
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
		ViewerUITO other = (ViewerUITO) obj;
		if (viewerName == null) {
			if (other.viewerName != null)
				return false;
		} else if (!viewerName.equals(other.viewerName))
			return false;
		return true;
	}

}
