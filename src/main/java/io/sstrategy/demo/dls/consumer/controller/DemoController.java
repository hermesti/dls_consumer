package io.sstrategy.demo.dls.consumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sstrategy.demo.dls.library.DatabaseService;
import io.sstrategy.demo.dls.library.Service;
import io.sstrategy.demo.dls.library.model.Animal;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
	
	@Autowired
	private Service service;
	
	@Autowired
	private DatabaseService databaseService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String get(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		Animal cat = new Animal();
		cat.setName("cat");
		databaseService.storeAnimal(cat);
		
		return "<h1>Hello world!</h1>"
				+ "<p>Service class message: " + service.getMessage() + "</p>"
				+ "<p>And I have stored a cat!</p>";
	}
	
}
