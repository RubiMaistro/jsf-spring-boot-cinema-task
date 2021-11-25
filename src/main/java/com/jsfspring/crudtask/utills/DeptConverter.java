package com.jsfspring.crudtask.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.crudtask.service.MovieService;
import com.jsfspring.crudtask.uito.MovieUITO;

@Service
public class DeptConverter implements Converter {

	@Autowired
	private MovieService movieService;

	private static final Logger LOG = LoggerFactory.getLogger(DeptConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + movieService);

		MovieUITO movieUITO = new MovieUITO();
		movieUITO.setDeptName(string);
		movieUITO = movieService.getMovie(movieUITO);
		System.out.println(movieUITO.toString());
		return movieUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof MovieUITO) {
			MovieUITO dept = (MovieUITO) obj;
			LOG.info("getAsString def name: " + dept.getDeptName());
			return dept.getDeptName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of MovieUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}