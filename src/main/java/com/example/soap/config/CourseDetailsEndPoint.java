package com.example.soap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soap.bean.Course;
import com.example.soap.service.CourseDetailsService;
import com.soapexample.courses.CourseDetails;
import com.soapexample.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndPoint {
	
	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace="http://soapexample.com/courses" ,localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload CourseDetails request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		Course course = service.findById(request.getId());
		
		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		
		response.setCourseDetails(courseDetails);
		return response;
	}

}
