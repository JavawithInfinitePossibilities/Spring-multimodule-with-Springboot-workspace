/**
 * 
 */
package com.tutorials.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorials.springboot.main.entities.StudentDB;

/**
 * @author Lenovo
 *
 */
public interface IStudentRepository extends JpaRepository<StudentDB, Long> {

}
