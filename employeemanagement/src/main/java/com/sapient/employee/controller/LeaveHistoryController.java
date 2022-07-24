package com.sapient.employee.controller;

import java.util.List;

import javax.validation.Valid;

import com.sapient.employee.entity.LeaveHistory;
import com.sapient.employee.service.LeaveHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave")
public class LeaveHistoryController {
	
	@Autowired
	LeaveHistoryService leaveService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<LeaveHistory>> getLeavesByUserId(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<>(leaveService.getLeaveByUserId(id), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/user") 
	public ResponseEntity<LeaveHistory> createLeave(@Valid @RequestBody LeaveHistory leaveHistory) {
		try {
			
			return new ResponseEntity<>(leaveService.createLeave(leaveHistory), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<List<LeaveHistory>> getLeavesByManagerId(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<>(leaveService.getLeaveHistoryByManagerId(id), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/leave") 
	public ResponseEntity<LeaveHistory> updateLeave(@RequestBody LeaveHistory leaveHistory) {
		try {
			
			return new ResponseEntity<>(leaveService.updateLeaveHistory(leaveHistory), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
