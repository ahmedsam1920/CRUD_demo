package com.okta.developer.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {

	@Id @GeneratedValue
	private Long id;
	
	
	private @NonNull String name;
	
	
}
