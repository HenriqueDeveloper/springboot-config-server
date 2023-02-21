package br.com.henrique.model;

public class Person {
	
	private final long id;
    private final String template;

	public Person(long id, String template) {
		this.id = id;
		this.template = template;
		
	}

	public long getId() {
		return id;
	}

	public String getTemplate() {
		return template;
	}
	
	

}
