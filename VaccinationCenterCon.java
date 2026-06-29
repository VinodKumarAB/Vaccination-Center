package com.ex.VaccinationCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ex.VaccinationCenter.Model.CitizenT;
import com.ex.VaccinationCenter.Model.RequiredResponse;
import com.ex.VaccinationCenter.Repo.CenterRepo;
import com.ex.VaccinationCenter.entity.VaccinationCenter;

@RestController
@RequestMapping("/vcenter")
public class VaccinationCenterCon {
	
	@Autowired
	private CenterRepo cnrepo;
	
	@Autowired
	private RestTemplate rest;
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter c){
		VaccinationCenter res=cnrepo.save(c);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDataCenter(@PathVariable Integer id){
		RequiredResponse response=new RequiredResponse();
		VaccinationCenter res=cnrepo.findById(id).get();
		response.setCenter(res);
		List<CitizenT> list=rest.getForObject("http://localhost:9999/citizen/id/"+id, List.class);
		response.setCity(list);
		
		return new ResponseEntity<RequiredResponse>(response,HttpStatus.OK);
	}
	

}
