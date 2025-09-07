package com.example.demo.controller;

import com.example.demo.model.Classroom;
import com.example.demo.repo.InMemoryClassroomRepository;
import com.example.demo.model.dto.AttendanceRequest;
import com.example.demo.model.dto.AttendanceResponse;
import com.example.demo.service.AttendanceService;

import jakarta.validation.Valid;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	private final AttendanceService attendanceService;
	private final InMemoryClassroomRepository classroomRepository;

 public AttendanceController(AttendanceService attendanceService,InMemoryClassroomRepository classroomRepository) {
	 this.attendanceService = attendanceService;   
	 this.classroomRepository = classroomRepository;
     }

 @GetMapping("/classrooms")
     public Collection<Classroom> classrooms() {
         return classroomRepository.findAll();
    }
 @PostMapping("/attendance/check")
 public ResponseEntity<AttendanceResponse> check(@Valid @RequestBody AttendanceRequest req) {
     return ResponseEntity.ok(attendanceService.check(req));
 }
}