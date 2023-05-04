package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.HospitalModel;
import com.example.demo.service.HospitalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
public class HospitalController {
	
		@Autowired
		HospitalService serv;
		
		@Operation(summary = "Add all the Patients")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data added successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		@PostMapping(value="/addPatient")
		public HospitalModel AddPatient(@RequestBody HospitalModel hos)
		{
			return serv.addPatient(hos);
		}
		
		public List<HospitalModel> listAll()
		{
			return serv.getPatient();
		}

		
		@Operation(summary = "Sort the Patients")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data sorted successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })


		   @GetMapping(value="/sortPatient/{field}")

		   public List<HospitalModel>sortPatient(@PathVariable String field) 

		   { 

			   return serv.SortPatient(field);

		   }

		   //pagination

		   // http://localhost:8080/pageStudents/0/1

		@Operation(summary = "Page the Patients data")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data paged successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		   @GetMapping(value="/pagingPatient/{offset}/{pageSize}")
		   public List<HospitalModel> pagingPatient(@PathVariable int offset,@PathVariable int pageSize)

		   {

			   return serv.pagingPatient(offset, pageSize);

		   }
		   
		   
		   //http://localhost:8080?fetchhStudentsByNamePrefix?prefix=a
		    
		@Operation(summary = "Page and Sort the Patients")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data paged and sorted successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		   @GetMapping(value="/pagingAndSorting/{offset}/{pagesize}/{field}")
		
		   public List<HospitalModel> PagingAndSorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field)
		   {
			   return serv.PagingAndSorting(offset, pagesize, field);
		   }
		@Operation(summary = "Delete the Patients by Name")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data deleted successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		   @DeleteMapping("/deletePatientByName/{firstname}")
		   public String deletePatientByName(@PathVariable String firstname)
		   {
		   int result=serv.deletePatientByName(firstname);
		   
		   if(result >0)
			   
		    return "Patient record deleted";
		   
		   else
			   
		    return "Problem occured while deleting";
		   
		   }
		@Operation(summary = "Get all the Patients")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data fetched successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })
		   @GetMapping("/fetchAll")
		   public List<HospitalModel> fetchAll()
		   {
		 return  serv.fetchAll();
		   }  
		   
		@Operation(summary = "Save all the Patients")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient data fetched successfully"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		   @PostMapping("/saveAll")
		   public HospitalModel saveAll(@RequestBody HospitalModel hos)
		   {
		  return serv.saveAll(hos);
		   }
		   
		   
		@Operation(summary = "Get Patients by Problem")

		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Patient fetched successfully by problem"),

				@ApiResponse(responseCode = "401", description = "Invalid credentials"),

				@ApiResponse(responseCode = "404", description = "Path not found") })

		   @GetMapping("/getPatientByProblem/{problem}")
		   public List<HospitalModel> getPatientByProblem(@PathVariable String problem)
		   {
		      return serv.getPatientByProblem(problem);
		   }
		   
		  

		   

		   

}
