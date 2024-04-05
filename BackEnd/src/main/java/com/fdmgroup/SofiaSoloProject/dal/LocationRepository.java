package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.SofiaSoloProject.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	List<Location> findAll();
	Location findById(int Id);
	
}
