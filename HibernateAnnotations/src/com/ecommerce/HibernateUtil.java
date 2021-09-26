package com.ecommerce;


import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateUtil {
	
	private static  SessionFactory sessionFactory ;
	
	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			 sessionFactory = metaData.getSessionFactoryBuilder().build();
			
		}catch (Exception th) {
			System.out.println(th.getLocalizedMessage());
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
