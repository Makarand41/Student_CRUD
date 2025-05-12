
package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<Student> createStudent(@RequestBody Student student )
	{
		Student newStudent = studentService.createStudent1(student);
		// return new ResponseEntity<>(newStudent, HttpStatus.CREATED);	
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getAll() {
	    List<Student> students = studentService.getStudents1();
	    return ResponseEntity.ok(students);  // Correct usage
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudentByID (@PathVariable("id") long iddd)
	{
		Student student=studentService.getStudentById(iddd);
		 return new ResponseEntity<>(student, HttpStatus.OK);	
		
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentByID (@PathVariable("id") long iddd)
	{
		studentService.deleteStudentbyId(iddd);
		 return new ResponseEntity<>("deleted"+iddd, HttpStatus.OK);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student updatedStudent) {
	    Student updatedStudentEntity = studentService.updateStudent(id, updatedStudent);
	    
	    if (updatedStudentEntity != null) {
	        return new ResponseEntity<>(updatedStudentEntity, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	    }
	}
	
	 @GetMapping("/count")
	    public ResponseEntity<Long> countStudents() {
	        long count = studentService.countStudents();
	        return new ResponseEntity<>(count, HttpStatus.OK);
	    }
	 
	 @GetMapping("/exists/{id}")
	    public ResponseEntity<Boolean> existsById(@PathVariable("id") Long studentId) {
	        boolean exists = studentService.existsById(studentId);
	        return new ResponseEntity<>(exists, HttpStatus.OK);
	    }

	 @DeleteMapping("/deleteAll")
	 public ResponseEntity<String> deleteAllStudents() {
	     studentService.deleteAllStudents();
	     return new ResponseEntity<>("All students deleted successfully!", HttpStatus.OK);
	 }

	

	
}
