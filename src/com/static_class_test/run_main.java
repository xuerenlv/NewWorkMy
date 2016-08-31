package com.static_class_test;

import com.static_class_test.util_out.util_in;

public class run_main {

	public static void main(String[] args) {
		util_out u = new util_out();

		// 普通内部类 
		util_in uin = u.new util_in();

		// 静态内部类
		new util_out.util_in_static();
	}

}
