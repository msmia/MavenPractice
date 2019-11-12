package com.automationpractice.qa.testcases;

import java.util.Enumeration;
import java.util.Properties;

public class SigninTest {

	public static void main(String[] args) {

		Properties prop = System.getProperties();
		Enumeration<Object> e = prop.keys();

		while (e.hasMoreElements()) {
			Object el = e.nextElement();
			Object v = prop.get(el);
			System.out.println(el+" === "+ v);
		}
	}

}
