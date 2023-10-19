package org.jsp.hibernatetemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCFG {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("hib-template.xml");
	System.out.println(context.getBean("hibernateTemplate"));
}
}
