package com.tutorials.springboot.main.repositories.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tutorials.springboot.main.entities.StudentDB;

public interface IStudentRepository extends JpaRepository<StudentDB, Long> {

	public List<StudentDB> findByName(String name);

	@Query("Select s from studentdb s where name like %:name% and test_score=:score")
	public List<StudentDB> findByNameLikeAndScore(@Param("name") String name, @Param("score") int score);
}
