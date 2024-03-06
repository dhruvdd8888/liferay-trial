package com.aixtor.meepay.models;

public class Designation {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Designation(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Designation [name=" + name + "]";
	}

	public Designation() {
		super();
	}
	
}
