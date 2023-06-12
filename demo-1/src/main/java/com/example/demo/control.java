package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class control {

	@Value("${app.name : Anitha }")
	private String name;
	@RequestMapping("/bob")
	public String helo()
	{
		return "Hello "+name;
	}
}
