package com.postgres.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.entities.Load;
import com.postgres.exception.ResourceNotFoundException;
import com.postgres.repository.LoadRepository;

@RestController
@RequestMapping("/api/v1")
public class LoadController {
     @Autowired
	private LoadRepository loadRepository;
	

	@GetMapping("/home")
	public String home() {
		return "Welcome to Live easy";
	}
	
	
	//get load
	@GetMapping("/loads")
	public List<Load> getLoads(){
		return this.loadRepository.findAll();
	}
	
	//get load by id
	@GetMapping("/loads/{shipperId}")
	public ResponseEntity<Load> getLoadId(@PathVariable (value = "shipperId") Long shipperId)
		throws  ResourceNotFoundException{
			Load load = loadRepository.findById(shipperId).
					orElseThrow(()-> new ResourceNotFoundException("Load found for this shipper id ::" +shipperId));
					return ResponseEntity.ok().body(load);
	  }
	//save load
	@PostMapping("/loads")
	public Load createLoad(@Validated @RequestBody Load load) {
		return this.loadRepository.save(load);
	}
	
	
	//update load
	@PutMapping("/loads/{shipperId}")
	public ResponseEntity<Load> updateLoad(@PathVariable (value = "shipperId") Long shipperId,
			@Validated @RequestBody Load loadDetails) throws ResourceNotFoundException{
		
		Load load = loadRepository.findById(shipperId).
				orElseThrow(()-> new ResourceNotFoundException("Load found for this shipper id ::" +shipperId));
		
		load.setLoadingPoint(loadDetails.getLoadingPoint());
		load.setUnloadingPoint(loadDetails.getUnloadingPoint());
		load.setProductType(loadDetails.getProductType());
		load.setTruckType(loadDetails.getTruckType());
		load.setNoOfTrucks(loadDetails.getNoOfTrucks());
		load.setWeight(loadDetails.getWeight());
		load.setComment(loadDetails.getComment());
		load.setDate(loadDetails.getDate());
		
		return ResponseEntity.ok(this.loadRepository.save(load));
		
		
	}
	//delete load
	@DeleteMapping("/loads/{shipperId}")
	public Map<String, Boolean> deleteLoad(@PathVariable (value = "shipperId") Long shipperId) throws ResourceNotFoundException{
		Load load = loadRepository.findById(shipperId).
				orElseThrow(()-> new ResourceNotFoundException("Load fpound for this shipper id ::" +shipperId));
		this.loadRepository.delete(load);
		
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
