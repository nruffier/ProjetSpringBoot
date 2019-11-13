package com.fr.adaming.enumeration;

public enum Fonction {
	DEV ("Devellopeur"),
	TESTEUR ("Testeur"),
	ARECHITECTE ("Architecte"),
	DEVOPS ("Dev Ops");
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Fonction(String name) {
		this.name = name;
	}
}
