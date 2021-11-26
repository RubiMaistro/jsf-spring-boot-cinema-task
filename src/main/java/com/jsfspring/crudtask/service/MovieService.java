
package com.jsfspring.crudtask.service;

import java.util.List;

import com.jsfspring.crudtask.uito.MovieUITO;
import com.jsfspring.crudtask.uito.ViewerUITO;

public interface MovieService {

	MovieUITO doSaveMovie(MovieUITO movieUITO);

	List<MovieUITO> getAllMovie(); 

	MovieUITO getMovie(MovieUITO movieUITO);

}