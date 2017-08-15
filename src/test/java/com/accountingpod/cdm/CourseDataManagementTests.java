package com.accountingpod.cdm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseDataManagementController.class)
public class CourseDataManagementTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMyobCourseModuleOrder() throws Exception {
    	String expectedMyobResponse = "{\"moduleA\":[\"A1\",\"A2\",\"A3\"],\"moduleB\":[\"B1\",\"B2\",\"B3\"],\"moduleC\":[\"C1\",\"C2\"]}";
    	
        this.mockMvc.perform(post("/getCourse/myob").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(expectedMyobResponse));
    }

    @Test
    public void testXeroCourseModuleOrder() throws Exception {
    	String expectedXeroResponse = "{\"moduleA\":[\"A1\",\"A2\",\"A3\"],\"moduleD\":[\"D1\",\"D2\",\"D3\",\"D4\"],\"moduleE\":[\"E1\"],\"moduleC\":[\"C1\",\"C2\"]}";
    	
        this.mockMvc.perform(post("/getCourse/xero").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(expectedXeroResponse));
    }
    

    @Test
    public void testMyobNewStudentEnrollment() throws Exception {
    	String expectedStudentEnrollment = "{\"1\":[{\"myob\":{\"moduleA\":\"N\",\"moduleB\":\"N\",\"moduleC\":\"N\"}}]}";
    	
        this.mockMvc.perform(post("/enrollStudent/myob/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(expectedStudentEnrollment));
    }
    
}
