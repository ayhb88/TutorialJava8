package com.tutorial.java8.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {
	
	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;
	
	public NashApp() {
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador = (Invocable) e;
	}
	
	public void llamarFunciones() throws Exception{
		//e.eval("print('JS desde Java')");
		e.eval(new FileReader("src/main/java/com/tutorial/java8/nashorn/archivo.js"));
		
		String resp = (String) invocador.invokeFunction("calcular", "2", "3");
		System.out.println(resp);
		
		double resp2 = (double) invocador.invokeFunction("calcular", 2, 3);
		System.out.println(resp2);
	}
	
	public void implementarInterfaz() throws Exception{
		e.eval(new FileReader("src/main/java/com/tutorial/java8/nashorn/archivo.js"));
		
		Object implementacion = e.get("hiloImple");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
	}
	
	public static void main(String[] args) {
		NashApp app = new NashApp();
		try {
			//app.llamarFunciones();
			app.implementarInterfaz();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
