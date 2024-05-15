package com.example.singleton;

public class SingletonLazyHolder {
	
	private static class InstanceHolder{	
		public static SingletonLazyHolder instancia = new SingletonLazyHolder();
	}
	
	private SingletonLazyHolder() {
		super();
	}
	
	public static SingletonLazyHolder getInstance() {
		return InstanceHolder.instancia;
	}

}
