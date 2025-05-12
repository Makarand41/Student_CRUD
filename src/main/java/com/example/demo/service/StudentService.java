package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;


@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	public Student createStudent1(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getStudents1() {
        return studentRepo.findAll();
    }
	
	
	 public Student getStudentById(Long studentId) {
	        Optional<Student> optionalStudent = studentRepo.findById(studentId);
	        return optionalStudent.orElse(null); 
	    }

	 
	 public void deleteStudentbyId(Long studentId)
	 {
		 studentRepo.deleteById(studentId);
	 }
	
	 public Student updateStudent(long id, Student updatedStudentData) {
		    Optional<Student> optionalStudent = studentRepo.findById(id);

		    if (optionalStudent.isPresent()) {
		        Student existingStudent = optionalStudent.get();		      
		        existingStudent.setName(updatedStudentData.getName());
		        existingStudent.setDept(updatedStudentData.getDept());
		        existingStudent.setDob(updatedStudentData.getDob());
		        return studentRepo.save(existingStudent); 
		    } else {
		        return null; 
		    }
		}


	 public long countStudents() {
	        return studentRepo.count();
	    }
	 
	 
	 public boolean existsById(Long studentId) {
	        return studentRepo.existsById(studentId);
	    }


	 public void deleteAllStudents() {
		    studentRepo.deleteAll();
		}


}