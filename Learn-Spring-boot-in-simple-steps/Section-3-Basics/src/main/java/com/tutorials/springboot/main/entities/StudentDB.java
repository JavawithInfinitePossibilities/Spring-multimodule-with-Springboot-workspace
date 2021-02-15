/**
 * 
 */
package com.tutorials.springboot.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Lenovo
 *
 */
@Entity
public class StudentDB {

	@Id
	private long id;
	private String name;
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
