/**
 * 
 */
package com.tutorials.springboot.main.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Lenovo
 *
 */
@Entity(name = "studentdb")
public class StudentDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fname")
	private String name;
	@Column(name = "test_score")
	private int testScore;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	@Override
	public String toString() {
		return "StudentDB [id=" + id + ", name=" + name + ", testScore=" + testScore + "]";
	}

}
