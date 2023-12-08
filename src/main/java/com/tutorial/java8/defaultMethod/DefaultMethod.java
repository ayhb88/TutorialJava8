package com.tutorial.java8.defaultMethod;

public class DefaultMethod implements PersonaA, PersonaB{
	
	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.hablar();
	}

	@Override
	public void caminar() {
		// TODO Auto-generated method stub
		System.out.println("Hola");		
	}

	@Override
	public void hablar() {
		// TODO Auto-generated method stub
		//PersonaB.super.hablar();
		System.out.println("sobrescribir");
	}

}
