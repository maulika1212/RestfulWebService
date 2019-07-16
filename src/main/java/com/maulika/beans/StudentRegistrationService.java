package com.maulika.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRegistrationService {
	private List<Student> studentRecords;
	private static StudentRegistrationService instance;

	private StudentRegistrationService() {
		studentRecords = new ArrayList<Student>();
	}

	public static StudentRegistrationService getInstance() {
		if(instance == null) {
			instance = new StudentRegistrationService();
		}
		return instance;
	}
	public void add(Student std) {
		studentRecords.add(std);
	}

	public String upDateStudent(Student std) {
		studentRecords = studentRecords.parallelStream()
				.map(student -> student.getRegistrationNumber().equalsIgnoreCase(std.getRegistrationNumber()) ? std
						: student)
				.collect(Collectors.toList());
		if (studentRecords.parallelStream().filter(student -> student.toString().equalsIgnoreCase(std.toString()))
				.count() == 1) {
			return "Update successful";
		}
		return "Update un-successful";
	}

	public String deleteStudent(String registrationNumber) {
		studentRecords = studentRecords.parallelStream()
				.filter(student -> !student.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
				.collect(Collectors.toList());
		if (studentRecords.parallelStream()
				.filter(student -> student.getRegistrationNumber().equalsIgnoreCase(registrationNumber)).count() == 0) {
			return "Delete successful";
		}

		return "Delete un-successful";
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

}
