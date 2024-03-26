package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	//Message findById(int messageId);
	
	@Query("SELECT m FROM Message m WHERE m.bookGroup.Id = :id ORDER BY m.date DESC")
	List<Message> findBybookGroupId(@Param("id") int id); 

}
