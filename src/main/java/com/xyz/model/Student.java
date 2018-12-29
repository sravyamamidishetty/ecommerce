package com.xyz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	@Id
	private String studentrno;
	private String studentname;
	private String studentemail;
	private String studentmobileno;
	private int[] marks= new int[5];
	private int total;
	private float average;
	private String result;
	private String grade;
	public String getStudentrno() {
		return studentrno;
	}
	public void setStudentrno(String studentrno) {
		this.studentrno = studentrno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public String getStudentmobileno() {
		return studentmobileno;
	}
	public void setStudentmobileno(String studentmobileno) {
		this.studentmobileno = studentmobileno;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
