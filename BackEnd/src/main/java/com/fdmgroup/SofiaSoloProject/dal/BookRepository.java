package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Author;
import com.fdmgroup.SofiaSoloProject.model.Book;
import com.fdmgroup.SofiaSoloProject.model.Genre;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	
	Book findByTitle(String title);
	
	@Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT('%',:title,'%')")
	List<Book> findPartialMatch(String title);

	@Query("SELECT b FROM Book b WHERE b.author.lname LIKE CONCAT('%', :name, '%')")
	List<Book> findByauthorName(@Param("name") String name);
	
	@Query("SELECT b.author FROM Book b WHERE b.id = :id")
	Author findAuthor(@Param("id") int id);
	
//	@Query("SELECT b FROM Book b WHERE b.genre LIKE b.genres.genreName")
//	List<Book> findByGenre(@Param(":genre") String genre);
		
}
