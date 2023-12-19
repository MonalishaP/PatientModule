package com.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> { //jparepository used to call all methods 
	//present in service(create, delete, update, save)

}
