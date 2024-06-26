package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	List<Author> findAll();
	

}
