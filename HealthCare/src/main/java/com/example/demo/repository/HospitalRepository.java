package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.HospitalModel;

public interface HospitalRepository extends JpaRepository <HospitalModel,Integer>{
	
	
	//DML
	@Modifying
	@Query("delete from HospitalModel h where h.firstname=?1")
	public int deletePatientByName(String firstname);
	
	//NamedParameter(select)
	@Query("select h from HospitalModel h where h.problem=:problem")
	public List<HospitalModel> getPatientByProblem(String problem);
	
	
	


}
