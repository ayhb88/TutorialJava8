package com.tutorial.java8.defaultMethod;

public interface PersonaA {
	
	public void caminar();
	default public void hablar() {
		System.out.println("Hablar P.A");
	}

}
