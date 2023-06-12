package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
	@GetMapping("/Home")
	public String demo(@RequestParam String name, @RequestParam int id)
	{
		return "Hi my Name is "+"<b>"+name+"</b> "+" My id is "+"<b>"+id+"</b>";
	}
}
