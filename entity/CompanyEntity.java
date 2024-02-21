package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Validation_Constraints")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Company name is compulsary")
	@Column(nullable = false)
	@Pattern(regexp = "^.{5,}$", message = "Company name should atleast be 5 characters")
	private String companyName;
	
	@NotBlank(message = "Email is compulsary")
	@Email(message = "Invalid Email address")
	private String email;
	
	@PositiveOrZero(message = "Strength should be positive number or zero")
	private Integer strength;
	
	private String webSiteURL;
	
	@Column(unique = true)
	@Pattern(regexp = "^[a - zA - Z]{2}\\a{2}[EN]$", message = "Invalid company code format")
	private String companyCode;

	public CompanyEntity(Long id,
			@NotBlank(message = "Company name is compulsary") @Pattern(regexp = "^.{5,}$", message = "Company name should atleast be 5 characters") String companyName,
			@NotBlank(message = "Email is compulsary") @Email(message = "Invalid Email address") String email,
			@PositiveOrZero(message = "Strength should be positive number or zero") Integer strength, String webSiteURL,
			@Pattern(regexp = "^[a - zA - Z]{2}\\a{2}[EN]$", message = "Invalid company code format") String companyCode) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.email = email;
		this.strength = strength;
		this.webSiteURL = webSiteURL;
		this.companyCode = companyCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public String getWebSiteURL() {
		return webSiteURL;
	}

	public void setWebSiteURL(String webSiteURL) {
		this.webSiteURL = webSiteURL;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public CompanyEntity() {
		super();
	}
	
	
}
