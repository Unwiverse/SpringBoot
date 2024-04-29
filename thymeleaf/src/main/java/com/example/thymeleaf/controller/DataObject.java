package com.example.thymeleaf.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data
@AllArgsConstructor
public class DataObject {
	
	private int num;
	private String name;
	private String email;
}
