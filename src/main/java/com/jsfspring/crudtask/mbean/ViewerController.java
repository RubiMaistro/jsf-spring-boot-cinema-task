/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.crudtask.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.service.ViewerService;
import com.jsfspring.crudtask.uito.MovieUITO;
import com.jsfspring.crudtask.uito.ViewerUITO;

@Controller("viewerController")
@SessionScope
public class ViewerController {
	@Autowired
	private ViewerService viewerService;

	@Autowired
	private MovieService movieService;

	private String actionLabel;
	private ViewerUITO viewerUiTO;
	private List<ViewerUITO> viewerUiToList;

	private List<MovieUITO> movieUiToList;

	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoViewer() {
		System.out.println(this.getViewerUiTO());
		viewerService.doSaveViewer(this.getViewerUiTO());
		getAllViewer();
		this.setViewerUiTO(new ViewerUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Viewer Details", "Viewer Details added/Updated Successfully."));

	}

	/**
	 * Default load all the Viewer info
	 */
	@PostConstruct
	public void getAllViewer() {
		if (!this.getViewerUiToList().isEmpty()) {
			this.getViewerUiToList().clear();
			this.getMovieUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + viewerService);
		this.getViewerUiToList().addAll(viewerService.doFetchAllViewer());
		this.getMovieUiToList().addAll(movieService.getAllMovie());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Viewer info
	 * 
	 * @return
	 */

	public void deleteViewer(ViewerUITO viewerUiTO) { 
		viewerService.doDeleteViewer(viewerUiTO);
		getAllViewer();
	}

	public void editViewer(ViewerUITO viewerUiTO) { 
		this.setActionLabel("Update");
		BeanUtils.copyProperties(viewerUiTO, this.getViewerUiTO());
		System.out.println(this.getViewerUiTO());
	}

	public ViewerUITO getViewerUiTO() {
		if (viewerUiTO == null) {
			viewerUiTO = new ViewerUITO();
		}
		return viewerUiTO;
	}

	public void setViewerUiTO(ViewerUITO viewerUiTO) {
		this.viewerUiTO = viewerUiTO;
	}

	public List<ViewerUITO> getViewerUiToList() {
		if (null == viewerUiToList) {
			viewerUiToList = new ArrayList<>();
		}
		return viewerUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<MovieUITO> getMovieUiToList() {
		if (movieUiToList == null) {
			movieUiToList = new ArrayList<>();
		}
		return movieUiToList;
	}

	public void setMovieUiToList(List<MovieUITO> movieUiToList) {
		this.movieUiToList = movieUiToList;
	}
}