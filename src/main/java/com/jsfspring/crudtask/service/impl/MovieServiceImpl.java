/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.crudtask.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.crudtask.entity.MovieDTO;
import com.jsfspring.crudtask.repositry.MovieRepo;
import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.uito.MovieUITO;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public List<MovieUITO> getAllMovie() {
		List<MovieUITO> movieUITOLst = new ArrayList<>();
		List<MovieDTO> movieDTOLst = movieRepo.findAll();

		movieDTOLst.forEach(dto -> {
			MovieUITO tmpUiTO = new MovieUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			movieUITOLst.add(tmpUiTO);
		});

		return movieUITOLst;
	}

	@Override
	public MovieUITO getMovie(MovieUITO movieUITO) {
		System.out.println(">>>>> "+movieUITO.getDeptName());
		MovieDTO dto = movieRepo.findTitleByDeptName(movieUITO.getDeptName());
		MovieUITO uito = new MovieUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}