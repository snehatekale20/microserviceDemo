package com.demo.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.service.entity.Student;

@RestController
@RequestMapping("/demo")
public class serviceController {
	
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/list")
	public List<Student> show() {
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(header);
		
		ResponseEntity<List>  rs =restTemplate.exchange("http://localhost:8080/student/get", HttpMethod.GET, entity, List.class);
		if(rs.getStatusCode().is2xxSuccessful()) {
			return rs.getBody();
		}
		return null;
	}
	
	@GetMapping("/savedata")
	public String saveURICall() {
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(header);
		
		Student st = new Student();
		st.setRollNo(103);
		st.setName("smita");
		st.setAddress("beed");
		st.setEmail("smita@gmail.com");
		st.setPhoneNo(23456789);
		
		ResponseEntity<String> rs = restTemplate.postForEntity("http://localhost:8080/student/save",st, String.class, header);
		
		if(rs.getStatusCode().is2xxSuccessful()) {
			return rs.getBody();
		}
		return null;
	}
	

	@PostMapping("/insertdata")
	public String saveData(@RequestBody Student st ) {
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(header);
		
	
		
		ResponseEntity<String> rs = restTemplate.postForEntity("http://localhost:8080/student/save",st, String.class, header);
		
		if(rs.getStatusCode().is2xxSuccessful()) {
			return rs.getBody();
		}
		return null;
	}
	
	

}
