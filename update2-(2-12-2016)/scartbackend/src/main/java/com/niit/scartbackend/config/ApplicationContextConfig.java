package com.niit.scartbackend.config;

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

import com.niit.scartbackend.model.BillingAddress;
import com.niit.scartbackend.model.Cart;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Order;
import com.niit.scartbackend.model.Product;
import com.niit.scartbackend.model.ShippingAddress;
import com.niit.scartbackend.model.Supplier;
import com.niit.scartbackend.model.User;

@Configuration
@ComponentScan("com.niit.scartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean(name="datasource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		 datasource.setDriverClassName("org.h2.Driver");
		 datasource.setUsername("sa");
	    	datasource.setPassword("");
	    	return datasource;
	    	
	}
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	   @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClass(Category.class);
	    	sessionBuilder.addAnnotatedClass(Supplier.class);
	      	sessionBuilder.addAnnotatedClass(User.class);
	      	sessionBuilder.addAnnotatedClass(Product.class);
	      	sessionBuilder.addAnnotatedClass(BillingAddress.class);
	      	sessionBuilder.addAnnotatedClass(ShippingAddress.class);
	      	sessionBuilder.addAnnotatedClass(Cart.class);
	      	sessionBuilder.addAnnotatedClass(Order.class);



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
