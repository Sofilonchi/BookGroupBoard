package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.AssignedBook;

@Repository
public interface AssignedBookRepository extends JpaRepository<AssignedBook, Integer>{
	
	List<AssignedBook> findAll();
	
	@Query("SELECT a FROM AssignedBook a WHERE a.bookGroup.id = :bookgroupId")
	List<AssignedBook> findBybookGroupId(@Param("bookgroupId") int bookgroupId);
	
	@Query("SELECT a FROM AssignedBook a WHERE a.book.id = :bookId")
	List<AssignedBook> findBybook(@Param("bookId") int bookId);
	
	//@Query("SELECT a FROM AssignedBook a WHERE a.assignmentKey.date = curdate AND a.assignmentKey.bookGroup.id = :bookgroupId")
	@Query("SELECT a FROM AssignedBook a WHERE a.bookGroup.id = :bookgroupId ORDER BY a.date DESC")
	List<AssignedBook> findCurrent(@Param("bookgroupId") int bookgroupID);

}
