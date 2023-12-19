package com.patient.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patient.entity.Patient;
import com.patient.exception.ResourceNotFoundException;
import com.patient.repo.PatientRepository;
@Service  //it annotates classes at the service layer
public class PatientService {
	@Autowired  //automatic dependency injection
	private PatientRepository patientRepository;
	
   public Patient create(Patient patient) {
	   Patient saveP = patientRepository.save(patient);
	   return saveP;
	
   }

 public  Patient update(String patientId, Patient  patient) {
	 Patient patId = patientRepository.findById(patientId).orElseThrow(() ->new ResourceNotFoundException("Not Found"));
	 //findById used for retrives an entity by its unique identifier.
	 //orElseThrow used to return the contained value otherwise throw an exception to be created by the supplier
	 patId.setAddress(patient.getAddress());
	 patId.setName(patient.getName());
	 Patient updatePat = patientRepository.save(patId);
	 return updatePat;
 }
 public List<Patient> getAll() {  //List create a list object
	 List<Patient> getall = patientRepository.findAll();//findAll allows us to get or retrive the entities from the database table.
	 return getall;
 }
 public Patient getDataById(String patientId) {
	
	Patient dataById = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
	return dataById;
 }
 
 public void deleteBYId( String patientId) {
	 patientRepository.deleteById(patientId);
	 
 }
}

