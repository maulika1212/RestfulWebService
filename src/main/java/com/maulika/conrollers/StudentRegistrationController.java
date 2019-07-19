package com.maulika.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maulika.beans.Student;
import com.maulika.beans.StudentRegistrationReply;
import com.maulika.beans.StudentRegistrationService;

@Controller
public class StudentRegistrationController {

	@RequestMapping(method = RequestMethod.POST, value = "/student/save")
	
	@ResponseBody
	  public StudentRegistrationReply registerStudent(@RequestBody Student student) {
	  System.out.println("In registerStudent");
	        StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
	        StudentRegistrationService.getInstance().add(student);
	        //We are setting the below value just to reply a message back to the caller
	        stdregreply.setName(student.getName());
	        stdregreply.setAge(student.getAge());
	        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
	        stdregreply.setRegistrationStatus("Successful");
	        return stdregreply;
	}

}
