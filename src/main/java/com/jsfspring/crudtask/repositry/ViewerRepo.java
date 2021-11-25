package com.jsfspring.crudtask.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.crudtask.entity.ViewerDTO;

@Repository
public interface ViewerRepo extends JpaRepository<ViewerDTO, Long> {
}