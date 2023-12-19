package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.service.PatientService;
import com.patient.util.ApiResponse;
import com.patient.entity.Patient;

@RestController //it is used for making restful web service or api(GET, POST, Delete, PUT). It allow the class to handle the requests made by client

@CrossOrigin //it used for controller and supports RESTAPI 
@RequestMapping("/api") //it handle request or url of any http method and rest controller


public class PatientController {
   @Autowired
   private  PatientService patientService;
   @PostMapping("/save")
   public String create(@RequestBody Patient patient) {
	   patientService.create(patient);
	   return "Saved Success";
   }
   @PutMapping("/update/{patientId}")
   public String update(@PathVariable String patientId, @RequestBody Patient patient) {
	 patientService.update(patientId, patient);
	 return "Update Success";
   }
   @GetMapping("/alldata") //it handle the get request
   public List<Patient>getAll(){
	   List<Patient> all = patientService.getAll();
	   return all;
   }
   @GetMapping("data/(patientId)")
  public Patient getById(@PathVariable String patientId) {
	  Patient dataById = patientService.getDataById(patientId);
	  return dataById;
  }
   @DeleteMapping("delete/(patient)")
   public ResponseEntity<ApiResponse>delete(@PathVariable String patientId){
	   patientService.deleteBYId(patientId);
	   return new ResponseEntity<>(new ApiResponse("Deleted Successfully"), HttpStatus.OK);
   }
  
   
}
