package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer>{

	@Query("SELECT m FROM Meeting m WHERE m.bookGroup.Id = :id AND m.date > curdate")
	Meeting findUpComing(@Param("id") int id);
	
	@Query("SELECT m FROM Meeting m WHERE m.bookGroup.Id = :id ORDER BY m.date DESC")
	List<Meeting> findByBookGroupId(@Param("id") int id);
	
}
