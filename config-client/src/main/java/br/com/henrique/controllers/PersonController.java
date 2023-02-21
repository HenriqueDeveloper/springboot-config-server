package br.com.henrique.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.henrique.configuration.PersonConfiguration;
import br.com.henrique.model.Person;

@RestController
public class PersonController {

	private static final String template = "A pessoa vinda do server é %s e tem %s anos!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonConfiguration configuration;

	@RequestMapping("/person")
	public Person greeting(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "age", defaultValue = "") Integer age) {

		if (name.isEmpty())
			name = configuration.getName();

		if (age == null)
			age = configuration.getAge();

		return new Person(counter.getAndIncrement(), String.format(template, name, age));

	}

}
