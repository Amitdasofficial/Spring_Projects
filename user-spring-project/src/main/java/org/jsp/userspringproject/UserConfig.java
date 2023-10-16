package org.jsp.userspringproject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "org.jsp.userspringproject")
public class UserConfig {
	@Bean
public EntityManager getEntityManager()
{
	return Persistence.createEntityManagerFactory("dev").createEntityManager();
}
}
