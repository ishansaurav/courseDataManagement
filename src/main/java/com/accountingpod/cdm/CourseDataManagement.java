package com.accountingpod.cdm;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDataManagement {
	LinkedHashMap<String, LinkedList> moduleMyobActions;
	LinkedHashMap<String, LinkedList> moduleXeroActions;
	
	CourseDataManagement()
	{
		moduleMyobActions = new LinkedHashMap<String, LinkedList>();
		moduleXeroActions = new LinkedHashMap<String, LinkedList>();
	}
	
	LinkedHashMap<String, LinkedList> addMyobCourses() {
		
		LinkedList<String> myobModuleA = new LinkedList<String>();
		myobModuleA.add("A1");
		myobModuleA.add("A2");
		myobModuleA.add("A3");
		
		LinkedList<String> myobModuleB = new LinkedList<String>();
		myobModuleB.add("B1");
		myobModuleB.add("B2");
		myobModuleB.add("B3");
		
		LinkedList<String> myobModuleC = new LinkedList<String>();
		myobModuleC.add("C1");
		myobModuleC.add("C2");

		moduleMyobActions.put("moduleA", myobModuleA);
		moduleMyobActions.put("moduleB", myobModuleB);
		moduleMyobActions.put("moduleC", myobModuleC);
		return moduleMyobActions;
	}

	LinkedHashMap<String, LinkedList> addXeroCourses() {
		
		LinkedList<String> xeroModuleA = new LinkedList<String>();
		xeroModuleA.add("A1");
		xeroModuleA.add("A2");
		xeroModuleA.add("A3");
		
		LinkedList<String> xeroModuleD = new LinkedList<String>();
		xeroModuleD.add("D1");
		xeroModuleD.add("D2");
		xeroModuleD.add("D3");
		xeroModuleD.add("D4");
		
		LinkedList<String> xeroModuleE = new LinkedList<String>();
		xeroModuleE.add("E1");
		
		LinkedList<String> xeroModuleC = new LinkedList<String>();
		xeroModuleC.add("C1");
		xeroModuleC.add("C2");
		
		moduleXeroActions.put("moduleA", xeroModuleA);
		moduleXeroActions.put("moduleD", xeroModuleD);
		moduleXeroActions.put("moduleE", xeroModuleE);
		moduleXeroActions.put("moduleC", xeroModuleC);

		return moduleXeroActions;
	}
}

