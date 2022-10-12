package com.springrestapi.springrestapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springrestapi.springrestapi.entities.Load;
import com.springrestapi.springrestapi.services.LoadService;

@RestController
public class MyController {
	@Autowired
	private LoadService loadService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Live easy";
	}
		
	//get the loads
		
	@GetMapping("/loads")
	public List<Load> getLoads()
	{
		return this.loadService.getLoads();
	
	}
	@GetMapping("/loads/{loadId}")
	public Load getLoad(@PathVariable String loadId)
	{
		return this.loadService.getLoad(Long.parseLong(loadId));
	}
	//add load
	@PostMapping("/loads")
	public Load addLoad(@RequestBody Load load) {
	
		return this.loadService.addLoad(load); 
	}
	//update load
		@PutMapping("/loads")
		public Load updateLoad(@RequestBody Load load) {
		
			return this.loadService.updateLoad(load); 
		}
		//delete load
		@DeleteMapping("/loads/{loadId}")
		public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId) {
			try {
			this.loadService.getLoad(Long.parseLong(loadId));
			return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		}
}
