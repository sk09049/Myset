package com.niit.project2.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.project2.collaboration.model.Blog;
import com.niit.project2.collaboration.model.BlogComment;
import com.niit.project2.collaboration.model.Chat;
import com.niit.project2.collaboration.model.Event;
import com.niit.project2.collaboration.model.Friend;
import com.niit.project2.collaboration.model.Job;
import com.niit.project2.collaboration.model.JobApplied;
import com.niit.project2.collaboration.model.User;

@Configuration
@ComponentScan("com.niit.project2.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name="datasource")
	public DataSource getOracleDataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 datasource.setUsername("ubuntu1");
	    	datasource.setPassword("password");
	    	Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        datasource.setConnectionProperties(properties);
	    	return datasource;
	    	
	}
	  
	  @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addAnnotatedClasses(User.class);
	    	sessionBuilder.addAnnotatedClasses(Job.class);
	    	sessionBuilder.addAnnotatedClasses(JobApplied.class);
	    	sessionBuilder.addAnnotatedClasses(Friend.class);
	    	sessionBuilder.addAnnotatedClasses(Blog.class);
	    	sessionBuilder.addAnnotatedClasses(BlogComment.class);
	    	sessionBuilder.addAnnotatedClasses(Event.class);
	    	sessionBuilder.addAnnotatedClasses(Chat.class);
	    	return sessionBuilder.buildSessionFactory();
	  }
	  
	  @Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	  }
