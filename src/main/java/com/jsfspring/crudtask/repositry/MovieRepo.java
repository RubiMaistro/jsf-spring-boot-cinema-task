package com.jsfspring.crudtask.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.crudtask.entity.MovieDTO;

@Repository
public interface MovieRepo extends JpaRepository<MovieDTO, Long> {

	MovieDTO findTitleByMovieName(String movieName);
}