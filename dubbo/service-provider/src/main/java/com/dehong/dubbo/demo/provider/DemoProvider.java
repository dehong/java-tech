package com.dehong.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProvider {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"dubbo-demo-provider.xml"});
		context.start();
		// press any key to exit
		System.in.read();
	}

}