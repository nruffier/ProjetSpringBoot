package com.fr.adaming.enumeration;

public enum Methodologie {
	SCRUM ("SCRUM"),
	CYCLEV ("Cycle en V");
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Methodologie(String name) {
		this.name = name;
	}
	
	
}
