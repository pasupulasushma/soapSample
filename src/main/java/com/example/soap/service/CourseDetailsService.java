package com.example.soap.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.soap.bean.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Spring", "Beginner");
		courses.add(course1);

		Course course2 = new Course(2, "Spring MVC", "Intermediate");
		courses.add(course2);

		Course course3 = new Course(3, "Spring Boot", "Advanced");
		courses.add(course3);

		Course course4 = new Course(4, "Maven", "Walkthrough");
		courses.add(course4);

	}

	// Find a Single Course by Id
	public Course findById(int i) {
		for (Course course : courses) {
			if (course.getId() == i)
				return course;
		}
		return null;
	}

	// List all the courses
	public List<Course> findAll() {
		return courses;
	}

	public int deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}

	

}
