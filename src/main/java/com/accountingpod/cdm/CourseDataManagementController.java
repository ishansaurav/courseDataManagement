package com.accountingpod.cdm;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class CourseDataManagementController {
	Map<String, LinkedHashMap> softwareCourses;
	StudentCourseManagement scm;
	CourseDataManagementController() throws IOException
	{
		CourseDataManagement cdm = new CourseDataManagement(); 
		scm = new StudentCourseManagement(cdm);
		
		softwareCourses = new HashMap<String, LinkedHashMap>();
		softwareCourses.put("myob", cdm.addMyobCourses());
		softwareCourses.put("xero", cdm.addXeroCourses());
	}

	@RequestMapping(value = "/getCourse/{software}", method = RequestMethod.POST)
    String getAccountingCourses(@PathVariable("software") String software) {
		if(software.equals("myob") || software.equals("xero"))
		{
			Gson gson = new Gson();
			return gson.toJson(softwareCourses.get(software),LinkedHashMap.class);
		}
		return "";
    }
	
	@RequestMapping(value = "/enrollStudent/{software}/{studentId}", method = RequestMethod.POST)
    String enrollStudent(@PathVariable("software") String software, @PathVariable("studentId") int studentId) {
		String studentsCourse = scm.enrollStudent(studentId, software);
		return studentsCourse;
    }
}

