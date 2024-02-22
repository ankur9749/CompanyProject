package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyEntity> getCompanyId(@PathVariable Long id) {
		return ResponseEntity.of(companyService.getCompanyById(id));
	}
	
	@GetMapping("/byCode/{companyCode}")
	public ResponseEntity<CompanyEntity> getCompanyByCode(@PathVariable String companyCode) {
		return ResponseEntity.of(companyService.getByCompanyCode(companyCode));
	}
	
	@PostMapping("/partialUpdate/{id}")
	public ResponseEntity<Object> partialUpdateCompany(@PathVariable Long id, @RequestBody CompanyEntity companyEntity) {
		companyService.partialUpdateCompany(id, companyEntity);
		return ResponseEntity.ok().build();
	}

}
