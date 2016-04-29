package com.atguigu.crm.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class connectionTest {
	
	private ApplicationContext ioc = null;
	
	{
		ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void test() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
