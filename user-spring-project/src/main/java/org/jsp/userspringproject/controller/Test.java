package org.jsp.userspringproject.controller;

import org.jsp.userspringproject.UserConfig;
import org.jsp.userspringproject.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(UserConfig.class);
	UserDao dao=context.getBean(UserDao.class);
	System.out.println(dao.manager);
}
}
