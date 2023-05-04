package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.HospitalModel;
import com.example.demo.repository.HospitalRepository;
import jakarta.transaction.Transactional;

@Service
public class HospitalService {
	
	
		
		@Autowired
		HospitalRepository hep;
		
		public HospitalModel addPatient(HospitalModel hos)
		{
			return hep.save(hos);
		}
		public List<HospitalModel> getPatient()
		{
			return hep.findAll();
		}
		
		public List<HospitalModel> getAllPatient()

		 {

			 List<HospitalModel>hosList=hep.findAll();

			 return hosList;

		 }

		 public HospitalModel savePatient(HospitalModel hos)

		 {

			 HospitalModel obj=hep.save(hos);

			 return obj;

		 }

		 public List<HospitalModel> SortPatient(String field) 

		 {

			   return hep.findAll(Sort.by(field));

		 } 

		 public List<HospitalModel> pagingPatient(int offset,int pageSize) 

		 {

			   Pageable paging=PageRequest.of(offset,pageSize);

			   Page<HospitalModel> hosData=hep.findAll(paging);

			   List<HospitalModel>hosList=hosData.getContent(); 

			   return hosList;

		 }
		 
		 public List<HospitalModel> PagingAndSorting(int offset,int pagesize,String field)
		 {
			 Pageable paging=PageRequest.of(pagesize, pagesize).withSort(Sort.by(field));
			 
			 Page<HospitalModel> stud=hep.findAll(paging);
			 
			 return stud.getContent();
		 }
		 
		 @Transactional
		 public int deletePatientByName(String firstname)
		 {
		  return hep.deletePatientByName(firstname);
		 }
		 public List<HospitalModel> fetchAll()
		 {
		return hep.findAll();
		 }
		 public HospitalModel saveAll(HospitalModel hos)
		 {
		return hep.save(hos);
		 }
		 
		 public List<HospitalModel> getPatientByProblem(String problem)
		 {
			 return hep.getPatientByProblem(problem);
		 }
		
		 


		 
		 
}
