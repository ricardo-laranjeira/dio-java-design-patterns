package com.example;

import com.example.facade.Facade;
import com.example.singleton.*;
import com.example.strategy.*;

public class Main {

	public static void main(String[] args) {
		testSingleton();
		testStratgy();
		
		Facade facade = new Facade();
		facade.migraCliente("Teste", "03063000");
	}
	
	public static void testStratgy() {
		
		Comportamento normal = new ComportamentoNormal();
		Comportamento agressivo = new ComportamentoAgressivo();
		Comportamento defensivo = new ComportamentoDefensivo();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		robo.mover();
	}
	
	public static void testSingleton() {
		
		SingletonLazy lazy = SingletonLazy.getInstance();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstance();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstance();
		System.out.println(eager);
		eager = SingletonEager.getInstance();
		System.out.println(eager);
		
		SingletonLazyHolder holder = SingletonLazyHolder.getInstance();
		System.out.println(holder);
		holder = SingletonLazyHolder.getInstance();
		System.out.println(holder);
	}

}
