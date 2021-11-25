package com.jsfspring.crudtask.mbean;

import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.uito.MovieUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller("movieController")
@SessionScope
public class MovieController {

    @Autowired
    private MovieService movieService;

    private String actionLabel;
    private MovieUITO movieUiTO;
    private List<MovieUITO> movieUiToList;
}
