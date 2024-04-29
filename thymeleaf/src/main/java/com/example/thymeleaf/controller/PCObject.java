package com.example.thymeleaf.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PCObject {
	
	private int ProNo;
	private String cpu;
	private String mainboard;
	private String ram;
	private String vga;
	
}
