package com.maulika.conrollers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maulika.beans.Student;
import com.maulika.beans.StudentRegistrationService;

@Controller
public class StudentRetrieveController {

	@RequestMapping(method = RequestMethod.GET, value="/student/info/all")

	@ResponseBody
	public List<Student> getAllStudents() {
		return StudentRegistrationService.getInstance().getStudentRecords();
	}

}
