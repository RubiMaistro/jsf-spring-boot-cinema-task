package com.jsfspring.crudtask.mbean;

import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.uito.MovieUITO;
import com.jsfspring.crudtask.uito.ViewerUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("movieController")
@SessionScope
public class MovieController {

    @Autowired
    private MovieService movieService;

    private String actionLabel;
    private MovieUITO movieUiTO;
    private List<MovieUITO> movieUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveMovie() {
        System.out.println(this.getMovieUiTO());
        movieService.doSaveMovie(this.getMovieUiTO());

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
        System.out.println(" >>>>>>>>>>>>> " + movieService);
        this.getMovieUiToList().addAll(movieService.getAllMovie());
        this.setActionLabel("Add");
    }

    public void setViewerUiTO(ViewerUITO viewerUiTO) {
        this.movieUiTO = movieUiTO;
    }

    public List<MovieUITO> getViewerUiToList() {
        if (null == movieUiToList) {
            movieUiToList = new ArrayList<>();
        }
        return movieUiToList;
    }

    public MovieUITO getMovieUiTO() {
        if (movieUiTO == null) {
            movieUiTO = new MovieUITO();
        }
        return movieUiTO;
    }

    public List<MovieUITO> getMovieUiToList() {
        if (movieUiToList == null) {
            movieUiToList = new ArrayList<>();
        }
        return movieUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }


}
