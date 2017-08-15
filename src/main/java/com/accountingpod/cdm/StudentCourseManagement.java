package com.accountingpod.cdm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class StudentCourseManagement {
	Map<Integer, Set<Map<String, LinkedHashMap<String, String>>>> studentCourses;
	CourseDataManagement cdm;
	StudentCourseManagement(CourseDataManagement cdm)
	{
		studentCourses = new HashMap<Integer, Set<Map<String, LinkedHashMap<String, String>>>>();
		this.cdm = cdm;
	}
	
	String enrollStudent(int stdId, String stdSoftware)
	{
		Set<String> courses = null;
		if(stdSoftware.equals("myob"))
			courses = cdm.addMyobCourses().keySet();
		else if(stdSoftware.equals("xero"))
			courses = cdm.addXeroCourses().keySet();
		
		LinkedHashMap<String, String> modules = new LinkedHashMap<String, String>(); 
		Map<String, LinkedHashMap<String, String>> courseModules = new HashMap<String, LinkedHashMap<String, String>>();
		if(courses!=null)
		{	
			for(String course:courses)
				modules.put(course, "N");
			courseModules.put(stdSoftware, modules);
			
			Set<Map<String, LinkedHashMap<String, String>>> coursesModules;
			
			if(!studentCourses.containsKey(stdId))
			{	
				coursesModules = new HashSet<Map<String, LinkedHashMap<String, String>>>();
				coursesModules.add(courseModules);
				studentCourses.put(stdId, coursesModules);
			}
			else
			{
				coursesModules = studentCourses.get(stdId);
				Set<Map<String, LinkedHashMap<String, String>>> coursesModulesCpy = new HashSet<Map<String, LinkedHashMap<String, String>>>();
				coursesModulesCpy.addAll(coursesModules);
				
				for(Map<String, LinkedHashMap<String, String>> studentCourse: coursesModules)
				{
					if(!studentCourse.keySet().contains(stdSoftware))
					{
						coursesModulesCpy.add(courseModules);
						studentCourses.put(stdId, coursesModulesCpy);
					}
					else
					{
						Set<Map<String, LinkedHashMap<String, String>>> currentCourses = studentCourses.get(stdId);
						currentCourses.add(courseModules);
						studentCourses.put(stdId, coursesModulesCpy);
					}
				}
			}
		}
		
		Gson gson = new Gson();
		return gson.toJson(studentCourses, Map.class);
	}
}