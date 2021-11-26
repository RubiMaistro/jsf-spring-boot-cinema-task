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

import com.jsfspring.crudtask.entity.ViewerDTO;
import com.jsfspring.crudtask.uito.ViewerUITO;
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
	@Transactional(readOnly = false)
	public MovieUITO doSaveMovie(MovieUITO movieUITO) {
		MovieDTO dto = UiToToDto(movieUITO);
		dto = movieRepo.save(dto);
		BeanUtils.copyProperties(dto, movieUITO);

		dtoToUito(movieUITO, dto);
		return movieUITO;
	}

	private void dtoToUito(MovieUITO movieUITO, MovieDTO dto) {
		MovieUITO uitTO = movieUITO;
		BeanUtils.copyProperties(dto, uitTO);
	}

	private MovieDTO UiToToDto(MovieUITO movieUITO) {
		MovieDTO movieDto = new MovieDTO();
		BeanUtils.copyProperties(movieUITO, movieDto);

		List<MovieDTO> lst = new ArrayList<>();
		lst.add(movieDto);

		return movieDto;
	}

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
		System.out.println(">>>>> "+movieUITO.getMovieName());
		MovieDTO dto = movieRepo.findTitleByMovieName(movieUITO.getMovieName());
		MovieUITO uito = new MovieUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}

	@Override
	@Transactional
	public void doDeleteMovie(MovieUITO movieUITO) {
		movieRepo.deleteById(movieUITO.getMovieId());
	}
}