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
import com.jsfspring.crudtask.entity.ViewerDTO;
import com.jsfspring.crudtask.repositry.ViewerRepo;
import com.jsfspring.crudtask.service.ViewerService;
import com.jsfspring.crudtask.uito.MovieUITO;
import com.jsfspring.crudtask.uito.ViewerUITO;

@Service
@Transactional
public class ViewerServiceImpl implements ViewerService {
	@Autowired
	ViewerRepo viewerRepo;

	@Override
	@Transactional(readOnly = false)
	public ViewerUITO doSaveViewer(ViewerUITO viewerUiTO) {
		ViewerDTO dto = UiToToDto(viewerUiTO);
		dto = viewerRepo.save(dto);
		BeanUtils.copyProperties(dto, viewerUiTO);

		dtoToUito(viewerUiTO, dto);
		return viewerUiTO;
	}

	private void dtoToUito(ViewerUITO viewerUiTO, ViewerDTO dto) {
		MovieUITO uitTO = new MovieUITO();
		BeanUtils.copyProperties(dto.getMovieDTO(), uitTO);
		viewerUiTO.setMovieUITO(uitTO);
	}

	private ViewerDTO UiToToDto(ViewerUITO viewerUiTO) {
		ViewerDTO dto = new ViewerDTO();
		MovieDTO movieDto = new MovieDTO();

		BeanUtils.copyProperties(viewerUiTO, dto);
		BeanUtils.copyProperties(viewerUiTO.getMovieUITO(), movieDto);
		dto.setMovieDTO(movieDto);

		List<ViewerDTO> lst = new ArrayList<>();
		lst.add(dto);
		movieDto.getViewerdtolst().addAll(lst);
		return dto;
	}

	@Override
	public List<ViewerUITO> doFetchAllViewer() {
		List<ViewerDTO> dtoLst = viewerRepo.findAll();
		List<ViewerUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			ViewerUITO tmpUiTO = new ViewerUITO();
			System.out.println(dto.getMovieDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);

			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public ViewerUITO doGetViewer(ViewerUITO viewerUiTO) {
		if (null != viewerUiTO.getEmailId()) {
			ViewerDTO dto = new ViewerDTO();

			BeanUtils.copyProperties(viewerUiTO, dto);
			dto = viewerRepo.getOne(dto.getViewerId());

			BeanUtils.copyProperties(dto, viewerUiTO);
		}
		return viewerUiTO;
	}

	@Override
	@Transactional
	public void doDeleteViewer(ViewerUITO viewerUiTO) {
		viewerRepo.deleteById(viewerUiTO.getViewerId());
	}

}