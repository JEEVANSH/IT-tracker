package com.ITOITTracker.ITTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.Response.Response;
import com.ITOITTracker.ITTracker.Services.AdminServices;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminServices adminServices;
	@GetMapping("/admins")
	public ResponseEntity<?> getAllAdmins() {
	if (adminServices.adminList().isEmpty())
	return new ResponseEntity<>(new Response("No Data Found"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(adminServices.adminList(), HttpStatus.FOUND);
	}
	@PostMapping("/admins")
	public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
	Admin a = adminServices.createAdmin(admin);
	return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
	}
	@GetMapping("/admins/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable("id") int id) {
	if (adminServices.getAdmin(id) == null)
	return new ResponseEntity<>(new Response("Invalid Admin Id"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(adminServices.getAdmin(id), HttpStatus.FOUND);
	}
	@PutMapping("/admins/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin) {
	return new ResponseEntity<>(adminServices.updateAdmin(id, admin), HttpStatus.OK);
	}
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) {
	if (adminServices.deleteAdmin(id))
	return new ResponseEntity<>(new Response("Invalid Admin Id"), HttpStatus.NOT_FOUND);
	return new ResponseEntity<>(new Response("Deleted Successfully"), HttpStatus.OK);
	}
}
