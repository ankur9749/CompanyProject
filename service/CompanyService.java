package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}
	
	public Optional<CompanyEntity> getCompanyById(Long id) {
		return companyRepository.findById(id);
	}
	
	public Optional<CompanyEntity> getByCompanyCode(String companyCode) {
		return companyRepository.findByCompanyCode(companyCode);
	}
	
	public CompanyEntity saveCompany(CompanyEntity companyEntity) {
		return companyRepository.save(companyEntity);
	}
	
	public void partialUpdateCompany(Long id, CompanyEntity companyEntity) {
		Optional<CompanyEntity> optionalCompany = companyRepository.findById(id);
		if(optionalCompany.isPresent()) {
			CompanyEntity company = optionalCompany.get();
			if(companyEntity.getCompanyName() != null) {
				company.setCompanyName(companyEntity.getCompanyName());
			}
			companyRepository.save(companyEntity);
		}
	}
}
