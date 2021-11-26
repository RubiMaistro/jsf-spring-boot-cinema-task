package com.jsfspring.crudtask.mbean;

import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.uito.MovieUITO;
import com.jsfspring.crudtask.uito.ViewerUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
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
        getAllMovie();
        this.setMovieUiToList(new MovieUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Movie Details", "Movie Details added/Updated Successfully."));
        this.movieUiTO = new MovieUITO();
    }

    /**
     * Default load all the Movie info
     */
    @PostConstruct
    public void getAllMovie() {
        if (!this.getMovieUiToList().isEmpty()) {
            this.getMovieUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + movieService);
        this.getMovieUiToList().addAll(movieService.getAllMovie());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Viewer info
     *
     * @return
     */
    public void deleteMovie(MovieUITO movieUITO) {
        movieService.doDeleteMovie(movieUITO);
        getAllMovie();
    }

    public void editMovie(MovieUITO movieUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(movieUITO, this.getMovieUiTO());
        System.out.println(this.getMovieUiTO());
    }

    public MovieUITO getMovieUiTO() {
        if (movieUiTO == null) {
            movieUiTO = new MovieUITO();
        }
        return movieUiTO;
    }

    public void setMovieUiToList(MovieUITO movieUITO) {
        this.movieUiTO = movieUITO;
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
