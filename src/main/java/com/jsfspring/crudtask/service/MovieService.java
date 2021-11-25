
package com.jsfspring.crudtask.service;

import java.util.List;

import com.jsfspring.crudtask.uito.MovieUITO;

public interface MovieService {

	List<MovieUITO> getAllMovie(); 

	MovieUITO getMovie(MovieUITO movieUITO);

}