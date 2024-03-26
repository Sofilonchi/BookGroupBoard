package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.BookGroup;

@Repository
public interface BookGroupRepository extends JpaRepository<BookGroup, Integer>{

	List<BookGroup> findAll();
	
	BookGroup findById(int bookGroupId);
	
	@Query("SELECT b FROM BookGroup b WHERE b.noOfMembers < 10")
	List<BookGroup> findAny();
	
	@Query("SELECT b FROM BookGroup b WHERE b.genre.Id = :genreId AND b.noOfMembers < 10")
	List<BookGroup> findGenreAvailable(@Param("genreId") int genreId);
	
	@Query("SELECT b FROM BookGroup b WHERE b.genre.Id = :genreId AND b.noOfMembers < 10 AND b.location.id = :locationId")
	List<BookGroup> findSpecificAvailable(@Param("genreId") int genreId, @Param("locationId") int locationId);
	
}
