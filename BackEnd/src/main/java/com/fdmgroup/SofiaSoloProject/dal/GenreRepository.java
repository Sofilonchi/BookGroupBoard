package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

	
	List<Genre> findAll();
	Genre findById(int genreId);
	
}
