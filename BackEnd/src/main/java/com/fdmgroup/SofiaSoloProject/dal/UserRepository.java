package com.fdmgroup.SofiaSoloProject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByname(String name);
	User findByUsername(String username);
	
	@Query("SELECT u.username FROM User u WHERE u.bookGroup.id = :id") //to find members of a book group
	List<String> findBybookGroup(@Param("id")Integer id);
	
	@Query("SELECT u FROM User u WHERE u.bookGroup.id IS null AND u.genre.id = :genreId")
	List<User> findCompatible(@Param("genreId") Integer genreId);
	
	@Query("SELECT u.bookGroup FROM User u WHERE u.id = :id") //to find the bookgroup a user belongs to
	BookGroup findUserBookGroup(@Param("id") Integer id);
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	List<User> checkUniqueId(@Param("username") String username);
	
	@Transactional
	void deleteById(int userId);
//	
//	@Transactional
//	User save(User user);
}
