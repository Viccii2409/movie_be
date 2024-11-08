package com.springboot.CinemaSystem.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Embeddable
public class Name {

	private String firstName;
	private String midName;
	private String lastName;

	@Transient
	private String fullname;

}