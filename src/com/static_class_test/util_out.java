package com.static_class_test;

public class util_out {
	
	static void method_o(){
		System.out.println("method o ");
	}
	
	public class util_in{
		util_in(){
			System.out.println("construct in");
		}
	}
	
	public static class util_in_static{
		public util_in_static() {
			System.out.println("util_in_static");
		}
	}
}
